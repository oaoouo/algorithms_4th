#ifndef QUEUE_H_
#define QUEUE_H_

// offsetof macro
#include <stddef.h>

typedef void *QUEUE[2]; // 双向链表节点

// QUEUE *q;
// q是一个指向QUEUE的指针
// private macros
#define QUEUE_NEXT(q)       (*((QUEUE **) &((*(q))[0])))
#define QUEUE_PREV(q)       (*((QUEUE **) &((*(q))[1])))
#define QUEUE_PREV_NEXT     (QUEUE_NEXT(QUEUE_PREV(q)))
#define QUEUE_NEXT_PREV     (QUEUE_PREV(QUEUE_NEXT(q)))

// public macros
// 指向type初始位置的指针:)
#define QUEUE_DATA(ptr, type, field)                                                        \
  ((type *)((char *)(ptr) - offsetof(type, field)))

// 遍历双向循环链表(最后一个节点的next指向头结点h)
#define QUEUE_FOREACH(q, h)                                                                 \
  for ((q) = QUEUE_NEXT(h); (q) != (h); (q) = QUEUE_NEXT(q)) 

// 此时队列中只有初始节点q
#define QUEUE_EMPTY(q)                                                                      \
  ((const QUEUE *)(q) == (const QUEUE *) QUEUE_NEXT(q))

#define QUEUE_HEAD(q)                                                                       \
  (QUEUE_NEXT(q))

// 初始化队列, 只有一个初始节点q
#define QUEUE_INIT(q)                                                                       \
  do {                                                                                      \
    QUEUE_NEXT(q) = (q);                                                                    \
    QUEUE_PREV(q) = (q);                                                                    \
  }                                                                                         \
  while (0)  

// 向表头插入一个节点
#define QUEUE_ADD(h, n)                                                                     \
  do {                                                                                      \
    QUEUE_PREV_NEXT(h) = QUEUE_NEXT(n);                                                     \
    QUEUE_NEXT_PREV(n) = QUEUE_PREV(h);                                                     \
    QUEUE_PREV(h) = QUEUE_PREV(n);                                                          \
    QUEUE_PREV_NEXT(h) = (h);                                                               \
  }                                                                                         \
  while (0)

// [p|n] [p|n]
// h   q
#define QUEUE_INSERT_HEAD(h, q)                                                             \
  do {                                                                                      \
    QUEUE_NEXT(q) = QUEUE_NEXT(h);                                                          \
    QUEUE_PREV(q) = (h);                                                                    \
    QUEUE_NEXT_PREV(q) = (q);                                                               \
    QUEUE_NEXT(h) = (q);                                                                    \
  }                                                                                         \
  while (0)

#endif
