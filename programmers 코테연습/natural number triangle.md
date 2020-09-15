## 정수 삼각형

https://programmers.co.kr/learn/courses/30/lessons/43105

###### 문제 설명

![스크린샷 2018-09-14 오후 5.44.19.png](https://grepp-programmers.s3.amazonaws.com/files/production/97ec02cc39/296a0863-a418-431d-9e8c-e57f7a9722ac.png)

위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다. 아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다. 예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.

삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.

##### 제한사항

- 삼각형의 높이는 1 이상 500 이하입니다.
- 삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수입니다.

##### 입출력 예

| triangle                                                | result |
| ------------------------------------------------------- | ------ |
| [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]] | 30     |



```python
def solution(triangle):
	# triangle 배열 복사
    r = triangle
    answer = 0
	# y: 라인번호 의미 : 두번째줄부터 마지막줄까지   
    for y in range(1,len(triangle)):
		# 마지막 줄 일때
        if y == len(triangle)-1:
			# 마지막 줄 안에 인덱스 불러오기
            for x in range(y+1):
				# 마지막 인덱스일때 (즉, 왼쪽 위에서만 값 받아올때)
                if x == y:
                    q = triangle[y][x]+ r[y-1][x-1]
				# 왼쪽, 오른쪽 위에서 값 받아오는거 중에 큰 값과 현재값의 합 찾기
                elif x-1>=0:
                    q = max(triangle[y][x]+r[y-1][x-1], triangle[y][x]+ r[y-1][x])
                # 첫번째 인덱스일때 (즉, 오른쪽 위에서만 값 받아올때)
				else :
                    q = triangle[y][x]+ r[y-1][x]
				# 더 큰 값이 있다면 answer 바꾸기	
                if answer < q:
                    answer = q  
			# 답 제출		
            return answer    
		# 마지막 줄 아닐때
        else:
			# 해당 줄 안에 인덱스 불러오기
            for x in range(y+1):
				# 마지막 인덱스일때 (즉, 왼쪽 위에서만 값 받아올때)
                if x == y:
                    q = triangle[y][x]+ r[y-1][x-1]
				# 왼쪽, 오른쪽 위에서 값 받아오는거 중에 큰 값과 현재값의 합 찾기	
                elif x-1>=0:
                    q = max(triangle[y][x]+r[y-1][x-1], triangle[y][x]+ r[y-1][x])
                # 첫번째 인덱스일때 (즉, 오른쪽 위에서만 값 받아올때)
				else :
                    q = triangle[y][x]+ r[y-1][x]
                # 위에서 계산한 값 r 배열에 넣기    
                r[y][x] = q
```



**다른 사람 간단한 풀이**

```python
def solution(triangle):
    memo = {}
    answer = f(triangle, 0, 0, memo)
    return answer
def f(triangle, i, j, memo):
    if i == len(triangle)-1:
        return triangle[i][j]
    if (i,j) in memo:
        return memo[(i,j)]
    a = f(triangle, i+1, j, memo)
    b = f(triangle, i+1, j+1, memo)
    x = triangle[i][j] + max(a, b)
    memo[(i,j)] = x
    return x

```



```python
def solution(triangle):
    dp = []
    for t in range(1, len(triangle)):
        for i in range(t+1):
            if i == 0:
                triangle[t][0] += triangle[t-1][0]
            elif i == t:
                triangle[t][-1] += triangle[t-1][-1]
            else:
                triangle[t][i] += max(triangle[t-1][i-1], triangle[t-1][i])
    return max(triangle[-1])
```

