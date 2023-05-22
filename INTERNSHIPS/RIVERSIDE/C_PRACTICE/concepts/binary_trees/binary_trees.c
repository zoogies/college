#include <stdio.h>

typedef struct node {
    struct node * left;
    struct node * right;
    int val;
} node_t;

int main() {
    node_t * test_list = (node_t *) malloc(sizeof(node_t));
    test_list->right = (node_t *) malloc(sizeof(node_t));
    test_list->val = 10;
    return 0;
}