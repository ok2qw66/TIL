def findCases(flag, cnt, current):
    global answer, n, k, weight

    if cnt == n:
        answer += 1
        return
    
    current -= k

    for i in range(n):
        if (1<<i & flag ==0) and weight[i]+current >= 0:
            findCases(flag| 1<< i, cnt+1, current+weight[i])
    

n, k = map(int, input().split())
weight = list(map(int, input().split()))
answer = 0
findCases(0,0,0)
print(answer)