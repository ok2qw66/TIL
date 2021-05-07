T = int(input())

for test_case in range(1, T + 1):
    num = int(input())
    students = list(map(int, input().split()))
    frequent = [0,0]
    for score in set(students):
        if students.count(score) > frequent[0] or (students.count(score) == frequent[0] and score > frequent[1]) :
            frequent = [students.count(score), score] 
    print(f'#{test_case} {frequent[1]}')