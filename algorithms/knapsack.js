'use strict'

function knapsack_dynamic(items, maxWeight) {

    const cache = [];

    for(let i=0; i<= items.length; i++) {
        cache[i] = []
        for(let j=0; j<= maxWeight; j++)
            cache[i][j] = 0;
    }
    
    for (let i = 1; i <= items.length; i++)
        for(let j = 0; j <= maxWeight; j++) 
            if (items[i - 1].w > j)
                cache[i][j] = cache[i-1][j]
            else
                cache[i][j] = Math.max(cache[i-1][j], cache[i-1][j - items[i - 1].w] + items[i - 1].v)

    /*for (let i = 0; i <= items.length; i++) {
        for(let j = 0; j <= maxWeight; j++) 
            process.stdout.write(' ' + cache[i][j])

        console.log()
    }*/

    return cache[items.length][maxWeight]
}

function knapsack_recursion(items, maxWeight, i) {

    if (i >= items.length)
        return 0

    if (maxWeight - items[i].w < 0)
        return knapsack_recursion(items, maxWeight, i + 1)

    return Math.max(knapsack_recursion(items, maxWeight - items[i].w, i + 1) + items[i].v,
                    knapsack_recursion(items, maxWeight, i + 1))
}

function knapsack(items, maxWeight) {
    return knapsack_recursion(items, maxWeight, 0)
}

const items = [{w:1, v:6}, {w:2, v:10}, {w:3, v:12}]
const maxWeight = 5

console.log(knapsack(items, maxWeight))
console.log(knapsack_dynamic(items, maxWeight))