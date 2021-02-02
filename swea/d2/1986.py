T = int(input())

for test_case in range(1, T + 1):
    number = int(input())
    print(f'#{test_case} {sum([num if num%2 else -num for num in range(1, number + 1)])}')
        