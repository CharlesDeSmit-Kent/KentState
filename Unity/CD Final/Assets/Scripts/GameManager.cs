using UnityEngine;
using UnityEngine.UI;
using System.Collections;

public class GameManager : MonoBehaviour
{
    public Text switchText;
    public Text winText;

    private int numberOfSwitchesOn;

    // Use this for initialization
    void Start()
    {

        numberOfSwitchesOn = 4;
        SetSwitchText();
        winText.text = "";
        //FIXME Add a line of code that initializes numberOfSwitchesOn to the number of GameObjects with the tag "Switch"
        //This should work automatically so when you add or remove switches the game adjusts
    }


    // Update is called once per frame
    void Update()
    {
        
        if (Input.GetMouseButtonDown(0))
        {

            Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition);
            RaycastHit hit;

            if (Physics.Raycast(ray, out hit))
            {


                if ((hit.transform.tag == "Switch") && hit.transform.GetComponent<Animator>().GetBool("SwitchOn"))
                {

                    Debug.Log("Touched Switch");
                    hit.transform.GetComponent<Animator>().SetBool("SwitchOn", false);
                    numberOfSwitchesOn--;
                    SetSwitchText();
                }

            }
        }
       
        //FIXME Add a conditional statement that checks to see if numberOfSwitchesOn == 0. If so display some text and letting the user know they won.
    }
    void SetSwitchText()
    {
        switchText.text = "Switchs remaining: " + numberOfSwitchesOn.ToString();
        if (numberOfSwitchesOn == 0)
        {
           winText.text = "Alarm disabled. YOU WIN!";
        }
    }
}