T = int(input())

for testCase in range(1, T + 1):
    num = int(input())
    answer = list(map(int, input().split()))
    answer.sort()
    answer = ' '.join(list(map(str,answer)))
    print(f'#{testCase} {answer}')