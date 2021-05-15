def solution(distance, rocks, n):
    answer = 0
    rocks.sort()
    rocks.append(distance)
    return findAnswer(0, distance, rocks, n)

def findAnswer(minVal, maxVal, rocks, n):
    if minVal >= maxVal : return minVal
    val = int((minVal+maxVal)/2)
    prev = 0
    count = 0
    
    for rock in rocks:
        if rock-prev < val:
            count += 1
        else:
            prev = rock
    
    if count > n: 
        return findAnswer(minVal, val, rocks, n)
    elif minVal==val: return minVal
    else:
        return findAnswer(val, maxVal, rocks, n)
