T = int(input())
dollars = [50000,10000,5000,1000,500,100,50,10]

for testCase in range(1, T +1):
    money = int(input())
    answer = []
    for dollar in dollars:
        if money >= dollar:
            temp = money // dollar
            answer.append(str(temp))
            money -= temp * dollar
        else:
            answer.append(str(0))

    print(f'#{testCase}')
    print(' '.join(answer))