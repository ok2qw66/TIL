# 파이썬을 파이썬답게

참고 : https://wikidocs.net/20464

### input :  eval() 함수 사용 - 유효한 파이썬 표현식으로 리턴

```python
data = int(input("정수를 입력하시오 : "))

# eval() 사용
string = eval( input("(1,2) 처럼입력하시오 "))
print(string, type(string))    # (1, 2) <class 'tuple'>


# 변수 2개이상 입력받기
a,b = map(int, input().strip().split(' '))

# 리스트 형태로 입력받기
data = list(map(int, input().strip().split(' ')))
```



### declare : 리스트 선언

```python
# 1차원 리스트 선언

# 2차원 리스트 선언 : 6 * 5 행렬 : row 행 / col 열
array = [[0] for col in range(6) for row in range(5)]
array = [[0]*6 for i in range(5)]
array = [[0]*11]*10
```



### map(funtion,<iterable>)

```python
# a요소를 정수로 바꾸기
# map(함수, 리스트 or 튜플의 변수명)
a = [1.5 , 1.9 , 13.5]
b = list(map(int, a))
print(b)
```



###  split

```python
x = "i am student, you are a girl"
b= x.split()  # 괄호안에 어떤 문자를 기준으로 분리할지 적습니다. 없으면 공백으로 분리
print(b)
```



------





### 1. 몫과 나머지 - divmod

###### divmod(a,b) ==> 몫(a/b)과 나머지(a%b) 순으로 출력

```python
# a, b를 입력받기
a, b = map(int, input().strip().split(' '))

print(*divmod(a, b))
```



### 2. n진법으로 표기된 string을 10진법 숫자로 변환하기 - int 함수

###### int(x , base = 10)  ==> string x 를 10진법 숫자로 변환한다

```python
num = '3212'
base = 5

# '3212' 를 5진법 숫자로 바꿈
answer = int(num, base)
```



### 3. 문자열 정렬하기 -  ljust, center, rjust

```python
s = '가나다라'
n = 7

s.ljust(n) # 좌측 정렬
s.center(n) # 가운데 정렬
s.rjust(n) # 우측 정렬
```



### 4. 알파벳 출력하기 - string 모듈

```python
import string 

string.ascii_lowercase # 소문자 abcdefghijklmnopqrstuvwxyz
string.ascii_uppercase # 대문자 ABCDEFGHIJKLMNOPQRSTUVWXYZ
string.ascii_letters #대소문자 모두 abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ
string.digits # 숫자 0123456789
```



### 5.  sequence 멤버를 하나로 이어붙이기 - join

```python
my_list = ['1', '100', '33']
answer = ''.join(my_list)   # 110033
answer2 = '/'.join(my_list) # 1/100/33
```



### 6. 원본을 유지한 채, 정렬된 리스트 구하기 - sorted

```python
list1 = [3, 2, 1]
list2 = sorted(list1)
```



### 7. 2차원 리스트 뒤집기 - zip

```python
mylist = [[1,2,3], [4,5,6], [7,8,9]]
# new_list = list(map(list, zip(mylist[0],mylist[1],mylist[2]))) 와 같은 의미
new_list = list(map(list, zip(*mylist)))   # [[1,4,7], [2,5,8], [3,6,9]]

animals = ['cat', 'dog', 'lion']
sounds = ['meow', 'woof', 'roar']
answer = dict(zip(animals, sounds)) # {'cat': 'meow', 'dog': 'woof', 'lion': 'roar'}
```



### 8. 모든 멤버의 type 변환하기 - map

```python
list1 = ['1', '100', '33']
list2 = list(map(int, list1))
```



### 9. sequence type의 * 연산 : n번 반복

```python
n = 숫자
answer= [123, 456]*n
```



### 10.  sequence 멤버를 하나로 이어붙이기 - join

```python
my_list = ['1', '100', '33']
answer = ''.join(my_list)   # 110033
answer2 = '/'.join(my_list) # 1/100/33
```



### 11. 2차원 리스트를 1차원 리스트로 만들기 - from_iterable

```python
my_list = [[1, 2], [3, 4], [5, 6]]

# 방법 1 - sum 함수
answer = sum(my_list, [])

# 방법 2 - itertools.chain
import itertools
list(itertools.chain.from_iterable(my_list))

# 방법 3 - itertools와 unpacking
import itertools
list(itertools.chain(*my_list))

# 방법4 - list comprehension 이용
[element for array in my_list for element in array]

# 방법 5 - reduce 함수 이용1
from functools import reduce
list(reduce(lambda x, y: x+y, my_list))

# 방법 6 - reduce 함수 이용2
from functools import reduce
import operator
list(reduce(operator.add, my_list))

# 방법 7 - numpy 라이브러리의 flatten 이용
import numpy as np
np.array(my_list).flatten().tolist()
```



### 12. 가장 많이 등장하는 알파벳 찾기 - Counter

```python
import collections
my_list = [1, 2, 3, 4, 5, 6, 7, 8, 7, 9, 1, 2, 3, 3, 5, 2, 6, 8, 9, 0, 1, 1, 4, 7, 0]
answer = collections.Counter(my_list)

print(answer[1]) # = 4
print(answer[3])  # = 3
print(answer[100]) # = 0
```





### 13. List comprehension

```python
mylist = [3, 2, 6, 7]
answer = [ i**2 for i in mylist if i %2 == 0]
```



### 14. for -else 문 : for 에 해당이 안되면 else로 적용한다

```python
import math
numbers = [int(input()) for _ in range(5)]
multiplied = 1
for number in numbers:
    multiplied *= number
    if math.sqrt(multiplied) == int(math.sqrt(multiplied)):
        print('found')
        break
else:
    print('not found')
```



### 15. swap

```python
a = 3
b = 'abc'
a,b = b,a
```



### 16. 이진 탐색하기 - binary search

```python
import bisect
mylist = [1, 2, 3, 7, 9, 11, 33]
print(bisect.bisect(mylist, 3))


# 다른 언어로 작성시에 참고
def bisect(a, x, lo=0, hi=None):
    if lo < 0:
        raise ValueError('lo must be non-negative')
    if hi is None:
        hi = len(a)
    while lo < hi:
        mid = (lo + hi) // 2
        if a[mid] < x:
            lo = mid + 1
        else:
            hi = mid
    return lo
```



### 17. 클래스 인스턴스 출력하기 - class의 자동 string casting

```python
# 파이썬에서는 __str__ 메소드를 사용해 class 내부에서 출력 format을 지정할 수 있습니다.

class Coord(object):
    def __init__ (self, x, y):
        self.x, self.y = x, y
    def __str__ (self):
        return '({}, {})'.format(self.x, self.y)

point = Coord(1, 2)
```



### 18. 가장 큰 수, inf

```python
# 파이썬이 제공하는 inf 를 사용해보세요. inf는 어떤 숫자와 비교해도 무조건 크다고 판정됩니다.

min_val = float('inf')
min_val > 10000000000

#inf에는 음수 기호를 붙이는 것도 가능합니다.
max_val = float('-inf')
```



### 19. 파일 입출력

```python
# 파일을 close 하지 않아도 됩니다: with - as 블록이 종료되면 파일이 자동으로 close 됩니다.
# readlines가 EOF까지만 읽으므로, while 문 안에서 EOF를 체크할 필요가 없습니다.

with open('myfile.txt') as file:
  for line in file.readlines():
    print(line.strip().split('\t'))
```









###### 문제 설명

동현이는 탁구공 공장을 운영하고 있습니다. 이 공장에서는 매일 조업 시간을 이용하여 탁구공을 생산하는데, 일별 생산량에는 차이가 있습니다. 하루의 조업이 끝나면 거래처에서 화물차를 보내어 그 날의 주문량을 운반하러 옵니다. 일별 주문량은 정해져 있지 않으며, 화물차가 온 후에야 그 날의 주문량을 알 수 있습니다.

만약 탁구공의 재고가 충분하다면, 그 날의 주문량을 화물차에 적재하고 탁구공의 판매 대금을 받습니다. 탁구공의 단가는 100 원으로 정해져 있습니다. 그런데, 탁구공의 재고가 충분하지 않다면 그 날은 하나도 납품하지 못하며 주문은 취소됩니다. 주문을 만족시키든 그렇지 못하든 생산된 탁구공은 재고로 관리하여 다음 날의 주문에 대응할 수 있습니다.

만약 어느 날의 주문량을 만족시키지 못하여 주문이 취소된 경우에는 거래처와의 계약에 따라 다음 날의 주문에 대하여 단가를 50 원으로 낮추어 공급하기로 되어 있습니다. 이때, 연속 이틀을 주문에 대응하지 못한다면 사흘째에는 25 원으로 낮추어 공급하기로 되어 있으며, 만약 사흘을 연달아 주문에 대응하지 못한다면 그것으로 거래 계약이 종료됩니다. 단, 공급 단가가 50 원이든 25 원이든 어느 날의 주문을 만족시키면 그다음 날의 탁구공 공급 단가는 다시 100 원으로 조정됩니다.

생산량과 주문량이 주어지는 날의 수 n, 일별 생산량을 담은 배열 p, 일별 주문량을 담은 배열 c가 매개변수로 주어질 때, 동현이의 탁구공 공장의 일일 매출 평균을 return 하도록 solution 함수를 완성해주세요.

##### 제한사항

- n은 1,000 이하의 자연수입니다.
- p의 길이는 n입니다.
  - p의 각 원소는 0 이상 100 이하의 정수입니다.
- c의 길이는 n입니다.
  - c의 각 원소는 0 이상 200 이하의 정수입니다.
- 일별 평균 매출액을 산출함에 있어서는 거래 계약이 유지되는 날까지 만의 평균을 계산합니다. 즉, 만약 사흘 연속으로 주문량을 만족시키지 못하여 계약이 종료되는 경우에는 그 날까지 만의 매출액을 그 날까지의 거래일 수로 나눈 평균을 계산하며, 그 이후의 날들에 대한 생산량과 주문량 입력은 무시합니다.
- 평균 매출액은 소수점 아래 셋째 자리에서 반올림하여 소수점 아래 둘째 자리까지를 문자열로 변환하여 리턴합니다.

##### 입출력 예

| n    | p                     | c                     | answer |
| ---- | --------------------- | --------------------- | ------ |
| 6    | [5, 4, 7, 2, 0, 6]    | [4, 6, 4, 9, 2, 3]    | 275.00 |
| 7    | [6, 2, 1, 0, 2, 4, 3] | [3, 6, 6, 2, 3, 7, 6] | 100.00 |

##### 입출력 예 설명

입출력 예 #1

n = 6 이므로, 6일 동안의 생산량과 주문량 데이터가 입력으로 주어집니다.

첫날은 탁구공 다섯 개를 생산하여 네 개를 공급하였으며, 매출액 400 원 (100 원 * 4 개) 이 기록됩니다. 공급하지 않은 탁구공 하나가 재고로 남아 있고, 다음 날 네 개의 탁구공을 생산하여 재고가 다섯 개가 됩니다. 그러나, 둘째 날의 주문량인 여섯 개는 만족하지 못하므로 이 날의 주문은 취소됩니다. 셋째 날에는 일곱 개를 추가 생산하여 열두 개의 재고가 남아 있게 되는데, 주문량이 네 개이므로 탁구공을 공급할 수 있습니다. 단, 단가를 50 원으로 계산하여 이 날의 매출액은 200 원 (50 원 * 4 개)입니다. 재고는 여덟 개가 됩니다. 넷째 날에는 두 개를 추가 생산하여 열 개의 재고를 보유한 상태에서 아홉 개의 주문을 받아 공급하여 900 원의 매출을 추가하고 (단가는 다시 100 원이 되었습니다) 재고는 한 개가 됩니다. 다섯째 날에는 탁구공을 하나도 생산하지 못하여 재고가 한 개인 상태에서 두 개의 주문을 받으므로 만족시키지 못하고 주문이 취소됩니다. 마지막으로 여섯째 날에는 여섯 개를 생산하여 재고가 일곱 개가 되고 세 개의 주문을 소화화여 매출 150 원 (50 원 * 3 개)을 추가합니다. 이 경우, 총 6일 동안 누적 매출액은 1,650 원이고, 따라서 일별 매출액 평균은 1,650 원 / 6 일 = 275 원입니다. 이때, 정답을 소수점 아래 둘째 자리까지로 반올림하여 문자열로 반환해야 되므로, 문자열 `”275.00”`를 정답으로 반환하면 됩니다.

입출력 예 #2

7일 치의 생산량과 주문량이 입력으로 주어지지만, 지문에서 설명한 규칙에 따라 거래가 이루어지는 경우 여섯째 날까지만 계약이 유지되고 (이때까지의 매출 총액은 300 + 0 + 300 + 0 + 0 + 0 = 600) 여섯째 날에 사흘 연속으로 주문을 만족시키지 못하여 계약이 종료됩니다. 따라서 일곱째 날의 생산량과 주문량 입력 데이터는 무시하고 600 원 / 6 일 = 100 원을 일별 매출액 평균으로 계산하여 `”100.00”` 을 리턴합니다.

![image-20200926102453814](C:\Users\i\AppData\Roaming\Typora\typora-user-images\image-20200926102453814.png)







###### 문제 설명

성냥개비 k개를 이용해서 숫자를 나타내려 합니다. 각 숫자를 만드는데 필요한 성냥개비는 다음 그림과 같습니다.

![match.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/c3b61701-621e-46f0-b130-65d172043625/match.png)

예를 들어 숫자 0을 만들기 위해서는 성냥개비 6개가 필요하며, 숫자 7을 만들기 위해서는 성냥개비 3개가 필요합니다. 두 자릿수 이상의 숫자를 만드는데 필요한 성냥개비 개수는 각 자릿수를 만드는데 필요한 성냥개비 개수의 합과 같습니다. 예를 들어 숫자 12를 만들기 위해서는 1(2) + 2(5) → 성냥개비 7개가 필요합니다.

성냥개비의 개수 k가 주어질 때, 성냥개비 k개를 `모두` 사용해서 만들 수 있는 숫자는 몇 가지인지 return 하도록 solution 함수를 완성해주세요.

##### 제한사항

- k는 1 이상 50 이하인 자연수입니다.
- 숫자 0 이외의 다른 숫자는 0으로 시작하지 않습니다.
- 만들 수 있는 숫자가 없는 경우에는 0을 return 하면 됩니다.

------

##### 입출력 예

| k    | result |
| ---- | ------ |
| 5    | 5      |
| 6    | 7      |
| 11   | 99     |
| 1    | 0      |

##### 입출력 예 설명

입출력 예 #1

성냥개비 5개로 만들 수 있는 숫자는 [2, 3, 5, 17, 71]로 총 5개입니다.

입출력 예 #2

성냥개비 6개로 만들 수 있는 숫자는 [0, 6, 9, 14, 41, 77, 111]로 총 7개입니다.

입출력 예 #3

설명 생략

입출력 예 #4

성냥개비 1개로 만들 수 있는 숫자는 없습니다.









###### 문제 설명

트리를 나타내는 간선들의 정보가 주어질 때, 간선 2개를 제거하여 부분 트리 세 개로 만들려 합니다. 이때, 각 부분 트리의 노드 개수가 모두 같아야 합니다. 다음은 노드가 9개인 트리의 예시입니다.

![tree_partion_2.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/918ec61b-c077-4a75-87f4-9b9439059541/tree_partion_2.png)

위 그림에서 동그라미 안에 적힌 숫자는 노드 번호, 간선에 적힌 숫자는 간선 번호를 나타냅니다. 위 예시와 같이 붉은색 간선(2번, 5번)을 제거하면 세 부분 트리로 나뉘며, 각 부분 트리에 속한 노드 개수는 3개로 모두 같습니다. 이때, 세 부분으로 분리된 부분 트리는 노드 수만 같으면 되며, 트리의 모양까지 같을 필요는 없습니다.

트리의 노드 개수 n, 트리의 간선 정보가 담긴 배열 edges가 매개변수로 주어질 때, 노드 수가 같은 부분 트리 세 개로 분리하기 위해 제거해야 하는 간선의 번호를 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.

##### 제한사항

- n은 3 이상 99 이하인 자연수입니다.
  - n은 항상 3의 배수로 주어집니다.
  - 각 노드에는 0부터 n - 1까지 번호가 하나씩 붙어 있습니다.
- edges의 길이는 n - 1입니다.
- edges의 각 원소는 [a, b] 형태입니다.
  - a, b는 간선이 연결하는 두 노드의 번호입니다.
  - 동일한 간선에 대한 정보가 중복해서 들어있지 않습니다.
  - 각 간선을 나타내는 인덱스가 해당 간선의 번호가 됩니다.
  - 예를 들어 edges[0]는 0번 간선, edges[1]은 1번 간선을 나타냅니다.
- 정답 배열은 오름차순 정렬해서 return 해주세요.
- 트리를 문제 설명과 같이 세 부분으로 분리할 수 없는 경우는 입력으로 주어지지 않습니다.
- 정확히 정답이 하나인 경우만 입력으로 주어집니다.

##### 입출력 예

| n    | edges                                             | result |
| ---- | ------------------------------------------------- | ------ |
| 9    | [[0,2],[2,1],[2,4],[3,5],[5,4],[5,7],[7,6],[6,8]] | [2,5]  |

##### 입출력 예 설명

입출력 예 #1

문제의 예시와 같습니다.

```
connect = [[] for _ in range(n+1)]
```

![image-20200926115954382](C:\Users\i\AppData\Roaming\Typora\typora-user-images\image-20200926115954382.png)

![image-20200926120022413](C:\Users\i\AppData\Roaming\Typora\typora-user-images\image-20200926120022413.png)

int is not subscripable 에러 발생...