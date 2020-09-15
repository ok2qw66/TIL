# 프린터(queue 문제)

https://programmers.co.kr/learn/courses/30/lessons/42587?language=python3



###### 문제 설명

일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.

```
1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.
```

예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.

내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.

현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때, 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.

##### 제한사항

- 현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
- 인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
- location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.

##### 입출력 예

| priorities         | location | return |
| ------------------ | -------- | ------ |
| [2, 1, 3, 2]       | 2        | 1      |
| [1, 1, 9, 1, 1, 1] | 0        | 5      |

##### 입출력 예 설명

예제 #1

문제에 나온 예와 같습니다.

예제 #2

6개의 문서(A, B, C, D, E, F)가 인쇄 대기목록에 있고 중요도가 1 1 9 1 1 1 이므로 C D E F A B 순으로 인쇄합니다.





------

#1 첫번째 풀이

```
def solution(priorities, location):
    answer = 0
    count = 0
    n = len(priorities)
    indexes = [0 for _ in range(n)]

    while priorities:
        value = priorities.pop(0)

        if not priorities or value >= max(priorities):
            answer += 1
            indexes[count//n] = answer
        else :
            priorities.append(value)
		
		count += 1

    return indexes[location]
```

> 에러 발생 원인 : count가 실제 value의 index를 가져오지 않는다...
>
> count//n은 0~n-1 숫자를 반복한다.
>
> 여기서 항상 index가 연속으로 나온다는 보장이 없고, index 순서가 뒤바뀔수도 있다!!
>
> ===> index를 처음부터 지정해주고 그 값을 불러오자!



#2. 두번째 풀이

```
def solution(priorities, location):
    answer = 0
    count = 0
    n = len(priorities)
    prior = [[x,priorities[x]] for x in range(n)]
    indexes = [0 for _ in range(n)]

    while prior:
        idx,value = prior.pop(0)

        if not prior or value >= max(priorities):
            answer += 1
            indexes[idx] = answer
            priorities[idx] = -1
        else :
            prior.append([idx,value])

    return indexes[location]
```

> 통과!





#### <<추가 공부!>>

#3. 더 쉬운 다른사람풀이

```
def solution(priorities, location):
    queue =  [(i,p) for i,p in enumerate(priorities)]
    answer = 0
    while True:
        cur = queue.pop(0)
        if any(cur[1] < q[1] for q in queue):
            queue.append(cur)
        else:
            answer += 1
            if cur[0] == location:
                return answer
```

> **배울점!**

1. enumerate 사용 : idx 가져올 수 있다

   ```
   # My Code
   prior = [[x,priorities[x]] for x in range(n)]
   
   # Recommend
   queue =  [(i,p) for i,p in enumerate(priorities)]
   ```

2. any 사용 : any() 안에 하나라도 만족하면 true!

   ```
   # My Code
   if not prior or value >= max(priorities):
   
   # Recommend
   if any(cur[1] < q[1] for q in queue):
   ```

3. 불필요한 indexes 없애기 : 원하는 index이면 바로 리턴하면 indexes 지정안해도 된다!

   ```
   # My Code
   indexes[idx] = answer
   indexes = [0 for _ in range(n)]
   
   # Recommend
   if cur[0] == location:
   	return answer
   ```

   