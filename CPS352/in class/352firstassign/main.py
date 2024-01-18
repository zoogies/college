"""
mimic students grade entering and analysis system
grades generated randomly
define a function eg generate() to generate a list of students with each element tuple type
tuple format (90: avg, 90: cps350, 100:cps480, 80:cps592)
asks user to enter number of students to generate
asks user for the range for each class
sort the list of grades by their average score
find out the average of cps 480 among students whose avg are within the range of 20%, 80% of the sorted list
"""

import random


def generate():
    length = int(input("How many students would you like to generate? "))

    grade_ranges = {"350low": int(input("Lower bound for 350 range: ")),
                    "350high": int(input("Upper bound for 350 range: ")),
                    "480low": int(input("Lower bound for 480 range: ")),
                    "480high": int(input("Upper bound for 480 range: ")),
                    "592low": int(input("Lower bound for 592 range: ")),
                    "592high": int(input("Upper bound for 592 range: "))}

    gen_students = []
    for i in range(length):
        first_grade = random.randint(grade_ranges["350low"], grade_ranges["350high"])
        second_grade = random.randint(grade_ranges["480low"], grade_ranges["480high"])
        third_grade = random.randint(grade_ranges["592low"], grade_ranges["592high"])
        average = int((first_grade + second_grade + third_grade) / 3)
        gen_students.append((average, first_grade, second_grade, third_grade))
    return gen_students


if __name__ == '__main__':
    students = sorted(generate(), reverse=True)

    cps_480_sum = 0
    range_count = 0

    for student in students[int(len(students) * 0.2):int(len(students) * 0.8)]:
        cps_480_sum += student[2]
        range_count += 1

    average_cps480 = int(cps_480_sum / range_count)
    print(f"The average score for CPS480 within students in the range of 20%-80% of average score between all classes: {average_cps480}")