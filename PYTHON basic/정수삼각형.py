def solution(triangle):
    r = triangle
    answer = 0
       
    for y in range(1,len(triangle)):
        if y == len(triangle)-1:
            for x in range(y+1):
                if x == y:
                    q = triangle[y][x]+ r[y-1][x-1]
                elif x-1>=0:
                    q = max(triangle[y][x]+r[y-1][x-1], triangle[y][x]+ r[y-1][x])
                else :
                    q = triangle[y][x]+ r[y-1][x]
                    
                if answer < q:
                    answer = q            
            return answer    
            
        else:
            for x in range(y+1):
                if x == y:
                    q = triangle[y][x]+ r[y-1][x-1]
                elif x-1>=0:
                    q = max(triangle[y][x]+r[y-1][x-1], triangle[y][x]+ r[y-1][x])
                else :
                    q = triangle[y][x]+ r[y-1][x]
                    
                r[y][x] = q
