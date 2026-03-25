import os, sys, argparse
from langchain_community.document_loaders import PyPDFLoader
from langchain_core.messages import  HumanMessage
from config.meta_config import  MODELL
from chatbot import build_Agent_Graph




def load_code(path):
    with open(path, "r") as f:
        content = f.read()
        return content if content else ""

def load_pdf(path):
    loader = PyPDFLoader(path)
    pages = loader.load()
    return "\n".join([p.page_content for p in pages])


def evaluate_solution(pdf, model_solution, student_solution, assignment):
    user_input = f""" 
    Es handelt um die Aufgabe {assignment} in der pdf:
    {load_pdf(pdf)}

    Hier ist die Lösung des Studenten:
    {load_code(student_solution)}
    """
    graph = build_Agent_Graph(MODELL)
    result = graph.invoke(
        {
            "human_assignment_state": [HumanMessage(content=user_input)],
            "sample_solution": f"Hier ist die Musterlösung\n{load_code(model_solution)}"
        }
    )

    print("Finales Ergebnis:")
    return result


def main():
    # sicherstellen, dass relative Pfade funktionieren:
    repo_root = os.path.dirname(os.path.abspath(__file__))
    os.chdir(repo_root)

    p = argparse.ArgumentParser()
    p.add_argument("--pdf", required=True)
    p.add_argument("--model-solution", required=True)
    p.add_argument("--student-solution", required=True)
    p.add_argument("--assignment", required=True)
    args = p.parse_args()

    # TODO: Agent starten (vorerst nur debug)
    print("ENTRY OK")

    result = evaluate_solution(
        args.pdf,
        args.model_solution,
        args.student_solution,
        args.assignment
    )

    print("Rückgabe aus evaluate_solution:")
    print(result)

    print("Exit")
    return 0

if __name__ == "__main__":

    sys.exit(main())