import csv

FILE_PATH = "MotorPHEmployeeData.csv"

def add_employee():
    with open(FILE_PATH, "a", newline="") as f:
        writer = csv.writer(f)
        writer.writerow([input("Enter employee ID: "), input("Enter employee name: "), input("Enter employee birthday: "), input("Enter employee position: "), input("Enter employee address: ")])
        print("Employee added successfully.")

def remove_employee():
    id = input("Enter employee ID to remove: ")
    employees = []
    with open(FILE_PATH, "r", newline="") as f:
        reader = csv.reader(f)
        for employee in reader:
            if employee[0] != id:
                employees.append(employee)
    with open(FILE_PATH, "w", newline="") as f:
        writer = csv.writer(f)
        writer.writerows(employees)
        print("Employee removed successfully." if len(employees) < len(list(csv.reader(open(FILE_PATH))))) else print("Employee not found.")

def search_employee():
    id = input("Enter employee ID to search: ")
    with open(FILE_PATH, "r", newline="") as f:
        reader = csv.reader(f)
        for employee in reader:
            if employee[0] == id:
                print(f"ID: {employee[0]}, Name: {employee[1]}, Birthday: {employee[2]}, Position: {employee[3]}, Address: {employee[4]}")
                return
        print("Employee not found.")

def display_employees():
    with open(FILE_PATH, "r", newline="") as f:
        reader = csv.reader(f)
        print("List of employees:")
        for employee in reader:
            print(f"ID: {employee[0]}, Name: {employee[1]}, Birthday: {employee[2]}, Position: {employee[3]}, Address: {employee[4]}")

while True:
    print("\nEmployee Information Management System")
    print("1. Add Employee")
    print("2. Remove Employee")
    print("3. Search Employee")
    print("4. Display Employees")
    print("5. Exit")

    choice = input("Enter your choice: ")

    if choice == "1":
        add_employee()
    elif choice == "2":
        remove_employee()
    elif choice == "3":
        search_employee()
    elif choice == "4":
        display_employees()
    elif choice == "5":
        break
    else:
        print("Invalid choice.")
