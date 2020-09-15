# 문제 2

###### 문제 설명

정수 n이 매개변수로 주어집니다. 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후, 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.

![examples.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/e1e53b93-dcdf-446f-b47f-e8ec1292a5e0/examples.png)

------

##### 제한사항

- n은 1 이상 1,000 이하입니다.

------

##### 입출력 예

| n    | result                                                    |
| ---- | --------------------------------------------------------- |
| 4    | `[1,2,9,3,10,8,4,5,6,7]`                                  |
| 5    | `[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]`                   |
| 6    | `[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]` |





## 답 풀이

```python
def solution(n):
    answer = []
    vector = [0,1,2]
    status = 1
    num = n-1
    temp = []
    xy = [n-1,0]
    copy_n = n-1
    count = 0

    for x in range(1,n+1):
        s_temp  = []
        for _ in range(x):
            s_temp.append(x)
        temp.append(s_temp)

    while num < n*(n+1)/2:
        menu = status%3
        num += 1
        count += 1
        temp[xy[0]][xy[1]] = num
        # 왼쪽 아래로
        if menu == vector[0]:
            xy[0] += 1
        # 오른쪽 일직선으로        
        elif menu == vector[1]:
            xy[1] += 1
        # 왼쪽 위로        
        else:
            xy[0] -=1
            xy[1] -=1

        if count == copy_n :
            status += 1
            count = 0
            copy_n -= 1

    for x in temp:
        for y in x :
            answer.append(y)

    return answer
```

