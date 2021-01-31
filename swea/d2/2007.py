T = int(input())

for test_case in range(1, T+1):
    words = str(input())
    start = words[0]
    temp = 1

    while temp < len(words) - 1:
        idx = words.find(start, temp)
        if words[:idx] == words[idx:idx*2]:
            temp = idx
            break
        else:
            temp = idx + 1
    
    print(f'#{test_case} {temp}')

