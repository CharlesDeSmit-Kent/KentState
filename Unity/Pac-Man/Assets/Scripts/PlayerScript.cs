using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerScript : MonoBehaviour {
    public float playerSpeed = 4.0f;
    public Sprite idle;
    Vector2 direction = Vector2.zero;
    Vector2 nextDirection;

    private Nodes currentNode, lastNode, targetNode;
    private int pelletsConsumed = 0;


    void Start() {
        Nodes node = GetCurrentNode(transform.localPosition);
        if (node != null)
        {
            currentNode = node;
            Debug.Log("The current node is " + currentNode);
        }
        //else Debug.Log("Could not find a node");
        direction = Vector2.left;
        ChangePosition(direction);
    }
    void Update () {
        Debug.Log("SCORE: " + GameObject.Find ("Game").GetComponent<GameBoard>().score);
        CheckDirection();
        Move();
        Rotate();
        UpdateAnimationState();
        ConsumePellet();
	}

    void CheckDirection(){
        if (Input.GetKeyDown(KeyCode.LeftArrow))
        {
            ChangePosition(Vector2.left);          
        }
        else if (Input.GetKeyDown(KeyCode.RightArrow))
        {
            ChangePosition(Vector2.right);
        }
        else if (Input.GetKeyDown(KeyCode.UpArrow))
        {
            ChangePosition(Vector2.up);
        }
        else if (Input.GetKeyDown(KeyCode.DownArrow))
        {
            ChangePosition(Vector2.down);
        }
    }
    void MoveToNode(Vector2 d)
    {
        Nodes nextNode = CanMove(d);
        if (nextNode != null)
        {
            transform.localPosition = nextNode.transform.position;
            currentNode = nextNode;
        }

    }
    void ChangePosition(Vector2 d)
    {
        if (d != direction) nextDirection = d;
        if (currentNode != null)
        {
            Nodes nextNode = CanMove(d);
            if(nextNode != null)
            {
                direction = d;
                targetNode = nextNode;
                lastNode = currentNode;
                currentNode = null;
            }
        }
    }
    void Move(){
        if (targetNode != currentNode && targetNode != null)
        {
            if(nextDirection == direction * -1)
            {
                direction *= -1;
                Nodes temp = targetNode;
                targetNode = lastNode;
                lastNode = temp;
            }
            if (OverShotTarget())
            {
                currentNode = targetNode;
                transform.localPosition = currentNode.transform.position;
                Nodes nextNode = CanMove(nextDirection);
                if (nextNode != null) direction = nextDirection;
                if (nextNode == null) nextNode = CanMove(direction);
                if (nextNode != null)
                {
                    targetNode = nextNode;
                    lastNode = currentNode;
                    currentNode = null;
                }else
                {
                    direction = Vector2.zero;
                }
            }else
            {
                transform.localPosition += (Vector3)(direction * playerSpeed) * Time.deltaTime;
            }
        }
    }
    void Rotate(){
        if (direction == Vector2.left){
            transform.localScale = new Vector3(-1, 1, 1);
            transform.localRotation = Quaternion.Euler(0, 0, 0);
        }
        else if (direction == Vector2.right){
            transform.localScale = new Vector3(1, 1, 1);
            transform.localRotation = Quaternion.Euler(0, 0, 0);
        }
        else if (direction == Vector2.up){
            transform.localScale = new Vector3(1, 1, 1);
            transform.localRotation = Quaternion.Euler(0, 0, 90);
        }
        else if (direction == Vector2.down){
            transform.localScale = new Vector3(1, 1, 1);
            transform.localRotation = Quaternion.Euler(0, 0, 270);
        }
    }
    Nodes CanMove(Vector2 d)
    {
        Nodes nextNode = null;

        for (int i = 0; i < currentNode.neighbors.Length; i++)
        {
            if (currentNode.directions[i] == d)
            {
                nextNode = currentNode.neighbors[i];
                break;
            }
        }
        return nextNode;
    }
    Nodes GetCurrentNode(Vector2 pos)
    {
        pos.x += 20;
        pos.y += 15;
        GameObject tile = GameObject.Find ("Game").GetComponent<GameBoard>().board [((int)pos.x), ((int)pos.y)];
        if (tile != null)
        {
            return tile.GetComponent<Nodes>();
        }
        return null;
    }
    bool OverShotTarget()
    {
        float nodeToTarget = LengthFromNode(targetNode.transform.position);
        float nodeToSelf = LengthFromNode(transform.localPosition);
        return nodeToSelf > nodeToTarget;
    }
    float LengthFromNode (Vector2 targetPosition)
    {
        Vector2 vec = targetPosition - (Vector2)lastNode.transform.position;
        return vec.sqrMagnitude;
    }

    GameObject GetTileAtPosition(Vector2 pos)
    {
        int tileX = Mathf.RoundToInt(pos.x + 19);
        int tileY = Mathf.RoundToInt(pos.y + 15);

        GameObject tile = GameObject.Find("Game").GetComponent<GameBoard>().board[tileX, tileY];
        if (tile != null)
            return tile;
        return null;
    }
    void UpdateAnimationState()
    {
        if (direction == Vector2.zero)
        {
            GetComponent<Animator>().enabled = false;
            GetComponent<SpriteRenderer>().sprite = idle;
        }
        else
        {
            GetComponent<Animator>().enabled = true;
        }
    }
    void ConsumePellet()
    {
        GameObject o = GetTileAtPosition(transform.position);
        if (0 != null)
        {
            Tile tile = o.GetComponent<Tile>();
            if (tile != null)
            {
                if (!tile.didConsume && (tile.isPellet || tile.isPowerUp))
                {
                    o.GetComponent<SpriteRenderer>().enabled = false;
                    tile.didConsume = true;
                    GameObject.Find("Game").GetComponent<GameBoard>().score += 1;
                    pelletsConsumed++;
                }
            }
        }
    }
}
