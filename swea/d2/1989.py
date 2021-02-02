T = int(input())

for test_case in range(1, T + 1):
    string = str(input())

    def find(start, end):
        if start >= end:
            return 1
        if string[start] == string[end]:
            return find(start + 1, end - 1)
        else:
            return 0
    print(f'#{test_case} {find(0, len(string) - 1)}')