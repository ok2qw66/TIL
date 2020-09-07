[타겟넘버 프로그래머스](https://programmers.co.kr/learn/courses/30/lessons/43165)


###### 문제 설명

n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

```
-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
```

사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.



------



```python
def solution(numbers, target):
    answer = 0
    
    def cal(numbers, target, current,answer):
        if not len(numbers):
              if target == current :
                    answer += 1
                    return answer
        else:
            answer = cal(numbers[1:],target,current+numbers[0],answer)
            answer = cal(numbers[1:],target,current-numbers[0],answer)
        return answer
    
    return cal(numbers,target,0,answer)
```

