T = int(input())

for test_case in range(1, T + 1):
    hour1, min1, hour2, min2 = list(map(int, input().split()))

    total_hour = hour1 + hour2
    total_min = min1 + min2

    if total_min >=60:
        total_hour += 1
        total_min -= 60
    
    total_hour = total_hour - 12 if total_hour > 12 else total_hour

    print(f'#{test_case} {total_hour} {total_min}')