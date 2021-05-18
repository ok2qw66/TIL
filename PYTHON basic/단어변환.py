def solution(begin, target, words):
    # 애초에 답이 없는 경우
    if target not in words:
        return 0
    
    # 다른 글자의 수 반환하는 함수
    def find_diff(a,b):
        count = 0
        for idx in range(len(a)):
            if a[idx] != b[idx]:
                count += 1
        return count
    
    answer = 0
    # 사용 확인
    verify = [0] * len(words)
    
    
    def change_one(current, target, words, deep_num):
        global answer
        # target에 도달했을 때
        if current == target :
            # 처음 찾았을 때
            if answer == 0:
                answer = deep_num
            elif answer > deep_num:
                answer = deep_num
        # target 찾을 때까지 반복
        else:
            for idx in range(len(words)):
                if verify[idx] ==0 and find_diff(current,words[idx]) == 1 :
                    verify[idx] = 1
                    change_one(words[idx],target,words,deep_num+1)
                    verify[idx] = 0
        
    change_one(begin,target,words,0)     
    
    
    return answer
