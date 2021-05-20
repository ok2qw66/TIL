def solution(n, times):
    maxTime = max(times) * n
    minTime = 1
    return findTime(minTime, maxTime, n, times)

def findTime(minTime, maxTime, n, times):
    # print(minTime, maxTime)
    if minTime >= maxTime:
        return minTime
    time = int((minTime + maxTime) / 2)
    person = 0
    for t in times:
        person += int(time/t)
    
    if person >= n:
        return findTime(minTime, time, n, times)
    else:
        return findTime(time+1, maxTime, n, times)
