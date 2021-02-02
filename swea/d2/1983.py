from operator import itemgetter
T = int(input())

for test_case in range(1, T + 1):
    n, k = list(map(int, input().split()))
    scores = []
    for i in range(1, n + 1):
        a, b, c = list(map(int, input().split()))
        scores.append({'idx': i, 'score': a*0.35 + b*0.45 + c*0.2})
    sorted_scores = sorted(scores, key=itemgetter('score'), reverse=True)
    # print(sorted_scores)
    
    for i, test in enumerate(sorted_scores, 1):
        if test['idx'] == k:
            temp = i / (n/10)
            break
    
    print(f'#{test_case}', end=' ')
    if temp <= 1:
        print('A+')
    elif temp <= 2:
        print('A0')
    elif temp <= 3:
        print('A-')
    elif temp <= 4:
        print('B+')
    elif temp <= 5:
        print('B0')
    elif temp <= 6:
        print('B-')
    elif temp <= 7:
        print('C+')
    elif temp <= 8:
        print('C0')
    elif temp <= 9:
        print('C-')
    else:
        print('D0')