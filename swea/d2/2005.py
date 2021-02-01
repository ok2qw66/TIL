T = int(input())

for test_case in range(1, T + 1):
    n = int(input())
    print(f'#{test_case}')
    print('1')
    line = '1 1'

    for _ in range(1, n):
        print(line)
        arr = line.split()
        line = '1'
        for idx in range(len(arr) - 1):
            line += ' '+str(int(arr[idx]) + int(arr[idx + 1]))
        line += ' 1'