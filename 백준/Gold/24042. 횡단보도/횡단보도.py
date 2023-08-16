import sys
import heapq

INF = sys.maxsize
n, m = map(int, sys.stdin.readline().rstrip().split())
nodes = [[] for _ in range(n+1)]
for i in range(m):
    node1, node2 = map(int, sys.stdin.readline().rstrip().split())
    nodes[node1].append([node2, i])
    nodes[node2].append([node1, i])

def Dijkstra():
    distances = [INF for _ in range(n+1)]
    distances[1] = 0
    pq = []
    heapq.heappush(pq, [0, 1])

    while pq:
        cur_cost, cur_node = heapq.heappop(pq)
        if distances[cur_node] < cur_cost: continue

        for next_node, next_time in nodes[cur_node]:
            next_cost = cur_cost + (next_time - cur_cost) % m

            if distances[next_node] > next_cost + 1:
                distances[next_node] = next_cost + 1
                heapq.heappush(pq, [next_cost + 1, next_node])

    return distances[n]

answer = Dijkstra()
print(answer)