import os
import traceback
import sys
from langchain_community.document_loaders import PyPDFLoader
from langchain_core.messages import  HumanMessage
from pathlib import Path
from config.meta_config import TASK_NUMBER, TASK, STUDENT_SOLUTION, MODELL
from config.locations import PYTHON_SAMPLE_SOLUTION, PYTHON_STUDENT_SOLUTION, PYTHON_LLM_LOG, PYTHON_TASKS_DIR
from chatbot import build_Agent_Graph


def load_code(dir, filename: str) -> str:
    path = os.path.join(dir, filename)
    if not os.path.isfile(path):
        return ""
    try:
        with open(path, "r", encoding="utf-8") as f:
            content = f.read()
            return content if content else ""
    except Exception:
        return ""
    
def load_pdf(filename: str) -> str:
    path = os.path.join(PYTHON_TASKS_DIR, filename)
    loader = PyPDFLoader(path)
    pages = loader.load()
    return "\n".join([p.page_content for p in pages])

def print_stream(stream):
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
        
def evaluate_solution(task_pdf, task_py):
    task = load_pdf(task_pdf)
    my_solution = load_code(PYTHON_STUDENT_SOLUTION, task_py)
    sample_solution= load_code(PYTHON_SAMPLE_SOLUTION, task_py)

    user_input = f""" 
        Es handelt um die {TASK_NUMBER} in der pdf:\n{task}
        Hier ist die Lösung des Studenten:\n{my_solution}
        """

    print_stream(build_Agent_Graph(MODELL).stream({
                                                "human_assignment_state": [HumanMessage(content=user_input)], 
                                                "sample_solution": f"Hier ist die Musterlösung\n {sample_solution}"
                                                },
                                                
                                                 stream_mode="values"))
    
def main():
    while True:
        try:
            user_input = input("User: ")
            if user_input.lower() in ["quit", "exit", "q"]:
                print("Goodbye!")
                break

            log_dir = PYTHON_LLM_LOG / MODELL
            log_dir.mkdir(parents=True, exist_ok=True) 
            log_path = log_dir / f"{TASK}.txt"

            with open(log_path, "w", encoding="utf-8") as log_file:
                old_stdout = sys.stdout
                try:
                    sys.stdout = log_file
                    evaluate_solution(
                        TASK,
                        STUDENT_SOLUTION,
                    )
                finally:
                    sys.stdout = old_stdout 
            print(f"✅ Log wurde gespeichert unter: {log_path}")

        except Exception as e:
            sys.stdout = sys.__stdout__
            print("❌ Fehler beim Schreiben des Logs:")
            print(e)
            traceback.print_exc()
            break

if __name__ == "__main__":
    main()