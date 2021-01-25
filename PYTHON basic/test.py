def solution(name):
    answer = []
    alphabet = [chr(i) for i in range(ord('A'),ord('Z')+1)]
    total = 0
    # 시작인덱스, 마지막인덱스
    a_length = [-1, -1]
    temp = -1

    for char in name:
        if char <= 'N':
            answer.append(alphabet.index(char))
        else:
            answer.append(len(alphabet) - alphabet.index(char))
    
    total = sum(answer)
  
    for i in range(len(answer)):
        if temp == -1 and not answer[i]:
            temp = i
        elif temp != -1 and answer[i]:
            if a_length[1] - a_length[0] < i - temp:
                a_length[0] = temp
                a_length[1] = i - 1
                temp = -1
                # print('>',a_length, temp)
        elif temp != -1 and i == len(answer) -1:
            a_length[1] = i

    print(a_length)
    if a_length[0] == -1:
        print('==1==')
        move = len(answer) - 1
    elif a_length[0] == 0:
        print('==2==')
        move = min(len(answer)-1, len(answer) - a_length[1])
    elif a_length[1] == len(answer) - 1:
        print('==3==')
        move = min(len(answer)-1, a_length[0] - 1)
    else:
        print('==4==')
        move = min(len(answer)-1, a_length[0]*2 + len(answer) - a_length[1] - 3, a_length[0] + (len(answer) - a_length[1])*2 - 3)

    return total + move


print(solution('BBBAAAB')) #8
print(solution('ABABAAAAABA')) #10
print(solution('CANAAAAANAN')) #48
print(solution('ABAAAAABAB')) #8
print(solution('ABABAAAAAB')) #8
print(solution('BABAAAAB')) #7
print(solution('AAA')) #0
print(solution('ABAAAAAAABA')) #6
print(solution('AAB')) #2
print(solution('AABAAAAAAABBB')) #11
print(solution('ZZZ')) #5
print(solution('BBBBAAAAAB')) #10
print(solution('BBBBAAAABA')) #12