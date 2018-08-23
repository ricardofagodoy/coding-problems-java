function search_breadth(graph, start, startsWith) {
    
        const queue = []
        queue.push(start)

	while(queue.length > 0) {

		const name = queue.shift()

		if (name.startsWith(startsWith))
			return name

		queue.push.apply(queue, graph[name])
	}

	return 'nobody'
}

const graph = {}

graph["me"] = ["Nath", "Greg", "Tom"]
graph["Nath"] = ["Amanda", "Gabi", "Tata"]
graph["Amanda"] = ["Gladys", "Polly", "Nanda"]
graph["Nanda"] = ["Paty"]

console.log('I found ' + search_breadth(graph, "me", "Pa"))
