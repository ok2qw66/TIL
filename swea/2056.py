T = int(input())
check = {'01':31, '02':28, '03':31, '04':30, '05':31, '06':30,'07':31, '08':31, '09':30, '10':31,'11':30, '12':31} 

# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    input_string = str(input())
    year = input_string[:4]
    month = input_string[4:6]
    day = input_string[6:]

    if month not in check.keys():
        print(f'#{test_case} -1')
        continue

    if 1 <= int(day) <= check[month]:
        print(f'#{test_case} {year}/{month}/{day}')
    else:
        print(f'#{test_case} -1')
    