## 가장 먼 노드

https://programmers.co.kr/learn/courses/30/lessons/49189



###### 문제 설명

n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다. 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다. 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.

노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때, 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.

##### 제한사항

- 노드의 개수 n은 2 이상 20,000 이하입니다.
- 간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
- vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.

##### 입출력 예

| n    | vertex                                                   | return |
| ---- | -------------------------------------------------------- | ------ |
| 6    | [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]] | 3      |

##### 입출력 예 설명

예제의 그래프를 표현하면 아래 그림과 같고, 1번 노드에서 가장 멀리 떨어진 노드는 4,5,6번 노드입니다.

![image.png](https://grepp-programmers.s3.amazonaws.com/files/ybm/fadbae38bb/dec85ab5-0273-47b3-ba73-fc0b5f6be28a.png)





```python
def solution(n, edge):
	# answer 구성 : [지나간 line의 개수, 동일한 line의 개수를 지난 노드의 수]
    answer = [0,0]
	# 연결된 노드의 번호 리스트
    connect = [[] for _ in range(n+1)]
	# 노드번호 방문 확인 리스트
    verify = [0 for _ in range(n+1)]
	# 1에서부터 시작하므로 1은 방문했다고 체크하기
    verify[1] = 1
	# 앞으로 이동할 대기 노드 리스트
	# (현재위치의 노드번호, 지난 line의 수)
    queue = [(1,0)]

	# 연결된 노드번호를 해당리스트에 넣어주기
	# 예를들어, x = [3,6] 이면 3과6이 연결되어있다는 말 
	# connect[3].append(6)    &    connect[6].append(3)
    for x in edge :
        connect[x[0]].append(x[1])
        connect[x[1]].append(x[0]) 
	
    while queue:
        num = queue.pop(0)
        # num[1](지나간 line의 수)가 현재 저장된 line의 수보다 크면
		# 즉, 더 멀리잇는 노드를 찾았다면
        if num[1] > answer[0]:
			# answer의 최대line지나간 개수 변경하고, 값은 1로 바꾼다
            answer[0] = num[1]
            answer[1] = 1
		# 지금 저장된 가장 먼 노드와 똑같은 거리의 있는 노드를 찾았다면
        elif num[1] == answer[0]:
			# 값만 1증가
            answer[1] += 1
        
		# 현재 노드와 연결된 노드리스트를 불러오기
        for x in connect[num[0]]:
			# 연결될 노드가 아직 한번도 방문한 적이 없다면
            if not verify[x]:
				# 방문했다고 표시해주기
                verify[x] = 1
				# 앞으로 이동할 대기 노드 리스트에 count+1 증가해준 상태로 넣기
                queue.append((x,num[1]+1))
	
	# 답 출력
    return answer[1]
```

