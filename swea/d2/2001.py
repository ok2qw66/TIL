T = int(input())

for test_case in range(1, T + 1):
    n, m = list(map(int, input().split()))
    fly_board = []
    max_val = 0
    for _ in range(n):
        input_row = list(map(int, input().split()))
        fly_row = []
        for i in range(len(input_row) - m + 1):
            fly_row.append(sum(input_row[i:i+m]))
        print(fly_row)
        fly_board.append(fly_row)

    print('fly_board', fly_board)

    for row in zip(*fly_board):
        print(row)
        for i in range(len(row) - m + 1):
            max_val = max(sum(row[i:i+m]), max_val)

    print(f'#{test_case} {max_val}')

