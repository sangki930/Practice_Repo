class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        max_sum = 0
        front = [0]
        back = [0]
        for i in range(k):
            front.append(front[-1]+cardPoints[i])
            back.append(back[-1]+cardPoints[-(i+1)])
        for i in range(k+1):
            max_sum = max(max_sum,front[i]+back[k-i])
        return max_sum