class Solution:
    def shortestDistance(self, words: List[str], word1: str, word2: str) -> int:
        index = {}

        for i, word in enumerate(words):
            if word not in index:
                index[word] = []

            index[word].append(i)

        ret = 10000000000

        occ1 = index[word1]
        occ2 = index[word2]


        i = 0
        j = 0

        while i < len(occ1) and j < len(occ2):
            ret = min(ret, abs(occ1[i] - occ2[j]))

            if occ1[i] < occ2[j]:
                i += 1
            else:
                j += 1

        return ret
