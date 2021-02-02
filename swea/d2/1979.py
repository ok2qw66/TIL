from operator import itemgetter
T = int(input())

for test_case in range(1, T + 1):
    n, k = list(map(int, input().split()))
    puzzle = [list(map(int, input().split())) for _ in range(n)]
    answer = 0
    for i in range(n-k+1):
        for j in range(n):
            print(i, j , i+k)
            # 마지막이라면
            if i + k == n:
                if sum(puzzle[j][i:i+k]) == k and puzzle[j][i-1] == 0:
                    # print(puzzle[j][i:i+k])
                    # print('answer + 5')
                    answer += 1
                if sum([puzzle[t][j] for t in range(i,i+k)]) == k and puzzle[i-1][j] == 0:
                    # print([puzzle[t][j] for t in range(i,i+k)])
                    # print('answer + 6')
                    answer += 1
            # 처음이라면
            elif i == 0:
                if sum(puzzle[j][i:i+k]) == k and puzzle[j][i+k] == 0:
                    # print(puzzle[j][i:i+k])
                    # print('answer + 1')
                    answer += 1
                if sum([puzzle[t][j] for t in range(i,i+k)]) == k and puzzle[i+k][j] == 0:
                    # print([puzzle[t][j] for t in range(i,i+k)])
                    # print('answer + 2')
                    answer += 1
            else:
                if sum(puzzle[j][i:i+k]) == k and puzzle[j][i+k] == 0 and puzzle[j][i-1] == 0:
                    print(puzzle[j][i:i+k])
                    print('answer + 3')
                    answer += 1
                if sum([puzzle[t][j] for t in range(i,i+k)]) == k and puzzle[i+k][j] == 0 and puzzle[i-1][j] == 0:
                    print([puzzle[t][j] for t in range(i,i+k)])
                    print('answer + 4')
                    answer += 1
    print(f'#{test_case} {answer}')