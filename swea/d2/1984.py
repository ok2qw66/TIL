T = int(input())

for test_case in range(1, T + 1):
    number_list = list(map(int, input().split()))
    number_list.remove(max(number_list))
    number_list.remove(min(number_list))

    print(f'#{test_case} {round(sum(number_list)/len(number_list))}')