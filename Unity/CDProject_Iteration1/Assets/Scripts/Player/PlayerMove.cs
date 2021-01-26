using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerMove : MonoBehaviour {

    public float speed = 6f;
    Vector3 movement;
    public float jumpHeight;
    public float playerGravity;
    public CharacterController control;


    void Awake()
    {
        control = GetComponent<CharacterController>();
    }


    void Update()
    {
        float h = Input.GetAxisRaw("Horizontal");
        float v = Input.GetAxisRaw("Vertical");
        Move(h, v);
        
    }

    void Move(float h, float v)
    {
        float tempY = movement.y;
        movement = (transform.forward * v) + (transform.right * h);
        movement = movement.normalized * speed;
        movement.y = tempY;
        if (control.isGrounded)
        {
            movement.y = 0f;
            if (Input.GetButtonDown("Jump")) movement.y = jumpHeight;
        }
        movement.y = movement.y + (Physics.gravity.y * playerGravity * Time.deltaTime);
        control.Move(movement * Time.deltaTime);
    }
    private void OnTriggerEnter(Collider other)
    {
        if (other.gameObject.CompareTag("Objective"))
        {
            other.gameObject.SetActive(false);
        }
    }
}