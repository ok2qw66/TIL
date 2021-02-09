T = int(input())

for testCase in range(1, T + 1):
    num = int(input())
    matrix = []
    answer = [['' for _ in range(3)] for _ in range(num)]
    for i in range(num):
        temp = list(map(str, input().split()))
        matrix.append(temp)

    for idx, col in enumerate(zip(*matrix)):
        print(col)
        for x in col:
            answer[idx][0] = x + answer[idx][0]
            answer[num-idx-1][2] += x 

    for idx, row in enumerate(matrix):
        temp = reversed(row)
        answer[num-idx-1][1] = ''.join(temp)

    print(f'#{testCase}')
    for row in answer:
        print(' '.join(row))
