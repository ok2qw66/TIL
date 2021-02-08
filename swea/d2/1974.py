T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    puzzle = [list(map(int, input().split())) for _ in range(9)]
    
    answer = 1
    sample = [i for i in range(1,10)]

    for i in range(9):
        if sorted(puzzle[i]) != sample:
            answer = 0
            break
        test = [puzzle[j][i] for j in range(9)]
        print(test)
        if sorted(test) != sample:
            answer = 0
            break

    if answer:
        for i in range(9):
            test = []
            x,y = divmod(i,3)
            x *= 3
            y *= 3
            for j in range(3):
                test.append(puzzle[x][y+j])
                test.append(puzzle[x+1][y+j])
                test.append(puzzle[x+2][y+j])
            if sorted(test) != sample:
                answer = 0
                break

    print(f'#{test_case} {answer}')
