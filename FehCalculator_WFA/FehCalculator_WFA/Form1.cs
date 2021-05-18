using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace FehCalculator_WFA
{
    public partial class Form1 : Form
    {
        //Grail cost variables
        int feathers = 0;
        int grails = 0;
        int copies = 0;
        int purchased = 0;

        //Flower cost variables
        int currentFler = 0;
        int upgradeFler = 0;
        int costFler = 0;
        int intervalFler = 0;

        //set numericUpDown Bounds
       

        public Form1()
        {
            InitializeComponent();
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
            //Error Check: Text box can't be null
            if (string.IsNullOrEmpty(textBox_copies.Text) || string.IsNullOrEmpty(textBox_grail.Text))
            {
                label_result.Text = "No input. Please enter a number";

            }
            //Error Check: Number must be entered
            else if (!textBox_copies.Text.All(char.IsDigit) || !textBox_grail.Text.All(char.IsDigit))
            {
                label_result.Text = "Invalid input. Please enter a number";
            }
            else
            {
                //convert text input into integers
                copies = Int16.Parse(textBox_grail.Text);
                purchased += Int16.Parse(textBox_copies.Text);

                //Error Check: You can't buy more then 20 copies of a single unit
                if (copies + purchased > 20)
                {
                    label_result.Text = "Invalid input. You can't buy this many units with grails";
                }
                else
                {
                    //feather cost
                    feathers = copies * 20000;

                    //grail cost
                    grails = 0;
                    for (int i = purchased; i < (copies - purchased); i++)
                    {
                        if (i < 9)
                            grails += 100 + (50 * i);
                        else
                            grails += 500;
                    }
                    label_result.Text = "This will cost " + grails + " grails and " + feathers + " feathers";
                }
            }
        }
        private void button_flowerCalc_Click(object sender, EventArgs e)
        {
            //Error Check: Text box can't be null
            if (string.IsNullOrEmpty(textBox_currentFlower.Text) || string.IsNullOrEmpty(textBox_upgradeFlower.Text))
            {
                label_flowerResult.Text = "No input. Please enter a number";

            }
            //Error Check: Number must be entered
            else if (!textBox_currentFlower.Text.All(char.IsDigit) || !textBox_upgradeFlower.Text.All(char.IsDigit))
            {
                label_flowerResult.Text = "Invalid input. Please enter a number";

            }
            else
            {
                currentFler = Int16.Parse(textBox_currentFlower.Text);
                upgradeFler = Int16.Parse(textBox_upgradeFlower.Text);
                int total = currentFler + upgradeFler;
                //Error Check: Total flower level can't exceed +10. If Checkbox.Checked can't exceed +15
                if ((checkBox_flower.Checked && (total > 15)) || (!checkBox_flower.Checked && (total > 10)))
                {
                    label_flowerResult.Text = "Invalid input. This flower level is too high";
                }
                else
                {
                    //if the unit is a pre-Book III Infantry unit
                    if (checkBox_flower.Checked)
                    {
                        for (int i = 1; i <= total; i++)
                        {
                            if (i == 11) intervalFler = 0;

                            if (i < 5)
                                intervalFler += 10;
                            if ((i >= 5) && (i < 7))
                                intervalFler += 20;
                            if ((i >= 7) && (i < 11))
                                intervalFler += 30;
                            if (i >= 11)
                                intervalFler += 40;
                            if (i > currentFler)
                                costFler += intervalFler;
                        }
                    }
                    //If unit is anything else
                    else
                    {

                        for (int i = 1; i <= total; i++)
                        {
                            if (i == 6) intervalFler = 0;
                            intervalFler += 40;
                            if (i > currentFler)
                                costFler += intervalFler;
                        }
                    }
                    label_flowerResult.Text = "That will cost " + costFler + " Flowers, and their flower level will be +" + total;
                    currentFler = 0;
                    upgradeFler = 0;
                    costFler = 0;
                    intervalFler = 0;
                }
            }
        }
        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button_codesCalc_Click(object sender, EventArgs e)
        {
            List<NumericUpDown> codesList = new List<NumericUpDown>();
            codesList.Add(upDown_tier1);
            codesList.Add(upDown_tier2);
            codesList.Add(upDown_tier3);
            codesList.Add(upDown_tier4);
            codesList.Add(upDown_tier5);
            int totalCodes = 0;
            int counter = 1;
            foreach (NumericUpDown a in codesList)
            {
                totalCodes += Convert.ToInt32(a.Value) * (400 * counter);
                ++counter;
            }
            label_codesResult.Text = "The total cost is " + totalCodes + " Codes";
        }
    }
}
