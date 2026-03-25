import os
import sys
from config.locations import PYTHON_TASKS_DIR, PYTHON_STUDENT_SOLUTION, PYTHON_LLM_LOG, PYTHON_SAMPLE_SOLUTION
from config.locations import JAVA_TASKS_DIR, JAVA_STUDENT_SOLUTION, JAVA_LLM_LOG, JAVA_SAMPLE_SOLUTION
from Tutor_chatbot.src.chatbot import build_Agent_Graph
from langchain_community.document_loaders import PyPDFLoader
from langchain_core.messages import  HumanMessage



modelle = ["gpt-4.1", "gemini/gemini-2.0-flash"]
task_names_pdf = ["blatt-03.pdf","blatt-04.pdf","blatt-07.pdf","blatt-10.pdf"]
task_names =["LinkedList.java","InsertionSort.java","SearchTree.java", "HashTableChaining.java"]
task_number = ["Aufgabe 1", "Aufgabe 2","Aufgabe 2","Aufgabe 2", ]

def load_code(dir, filename: str) -> str:
    """
    Loads the content of a file from the given directory.

    If the file does not exist, is empty, or cannot be read (e.g., due to
    permission issues), an empty string is returned.
    """

    path = os.path.join(dir, filename)

    # If the file does not exist → return an empty string
    if not os.path.isfile(path):
        return ""
    try:
        with open(path, "r", encoding="utf-8") as f:
            content = f.read()
            # If the file is empty → return an empty string
            return content if content else ""
    except Exception:
        # If anything goes wrong (e.g., permission issues)
        return ""
    
def load_pdf( filename: str) -> str:
    """
    Loads a PDF file from the Java tasks directory and extracts its text content.

    The function reads all pages of the specified PDF file and concatenates
    their text into a single string separated by newline characters.
    """

    path = os.path.join(JAVA_TASKS_DIR, filename)
    loader = PyPDFLoader(path)
    pages = loader.load()
    return "\n".join([p.page_content for p in pages])

def print_stream(stream):
    """
    Iterates over a stream of state updates and prints newly added messages.

    The function tracks the last printed state for each message category
    (main messages, retriever messages, pattern/muster messages, and
    aggregator messages) and only prints a message when a change is detected.
    Each message is printed using its `pretty_print()` method.
    """

    last_retriever_state = None
    last_muster_state= None
    last_aggregator_state= None
    last_message_state= None
    for s in stream:
        if s["human_assignment_state"] != last_message_state:
            if s["human_assignment_state"]:
                s["human_assignment_state"][-1].pretty_print()
        last_message_state = list(s["human_assignment_state"])
    
        if s["retriever_state"] != last_retriever_state:
            if s["retriever_state"]:
                s["retriever_state"][-1].pretty_print()
        last_retriever_state = list(s["retriever_state"])

        if s["muster_state"] != last_muster_state:
            if s["muster_state"]:
                s["muster_state"][-1].pretty_print()
        last_muster_state = list(s["muster_state"])

        if s["aggregator_state"] != last_aggregator_state:
            if s["aggregator_state"]:
                s["aggregator_state"][-1].pretty_print()
        last_aggregator_state = list(s["aggregator_state"])
        
def evaluate_solution_without_sampleSolution(task_pdf, task_name, aufgabe_nummer, modell):
    """
    Evaluates a student's solution for a given task using an agent-based workflow.
    """

    # Load documents
    task = load_pdf(task_pdf)
    my_solution = load_code(JAVA_STUDENT_SOLUTION ,task_name)
    sample_solution = load_code(JAVA_SAMPLE_SOLUTION ,task_name)

    user_input = f""" 
    
        Es handelt um die {aufgabe_nummer} in der pdf:\n{task}
        Hier ist die Lösung des Studenten:\n{my_solution}

        """
    
    print_stream(build_Agent_Graph(modell).stream({
                                                "human_assignment_state": [HumanMessage(content=user_input)], 
                                                "sample_solution": f"Hier ist die Musterlösung\n {sample_solution}"
                                                },
                                                
                                                 stream_mode="values"))
    
def logging(modell:str , task_pdf, task_name, task_number):
    """
    Runs the solution evaluation and logs all console output to a file.
    """

    # Target directory
    log_dir = JAVA_LLM_LOG / modell
    log_dir.mkdir(parents=True, exist_ok=True) 
    log_path = log_dir / f"{task_pdf}.txt"

    # Open the file and redirect stdout
    with open(log_path, "w", encoding="utf-8") as log_file:
        old_stdout = sys.stdout
        try:
            sys.stdout = log_file
            evaluate_solution_without_sampleSolution(
                task_pdf,
                task_name,
                aufgabe_nummer= task_number, 
                modell= modell
            )
        finally:
            sys.stdout = old_stdout 

    print(f"✅ Log wurde gespeichert unter: {log_path}")

def main():
    for gpt in modelle:
        for i, pdf in enumerate(task_names_pdf):
            logging(gpt, pdf, task_names[i] , task_number[i])


if __name__ == "__main__":
    main()