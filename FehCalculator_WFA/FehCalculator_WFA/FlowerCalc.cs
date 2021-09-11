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
    public partial class FlowerCalc : Form
    {
        public FlowerCalc()
        {
            InitializeComponent();
            label_infantry.Visible = false;
            checkBox_infantry.Visible = false;
            comboBox_movement.DataSource = Enum.GetValues(typeof(movement));
        }

        private void buttonGrailForm_Click(object sender, EventArgs e)
        {
            Form1 grail = new Form1();
            grail.Show();
            this.Hide();
        }

        private void button_flowerCalc_Click(object sender, EventArgs e)
        {

            int currentFlwr = Convert.ToInt32(Math.Round(numericUpDown_currentFlower.Value, 0));
            int upgradeFlwr = Convert.ToInt32(Math.Round(numericUpDown_upgradeFlower.Value, 0));
            int totalFlwr = currentFlwr + upgradeFlwr;
            //Error Check: Flower number can't exceed 15, or 20 in the case of a pre Book III infantry 
            if (((totalFlwr > 15) && (checkBox_infantry.Checked == false)) || 
                ((totalFlwr > 20) && (checkBox_infantry.Checked == true)))
            {
                label_flowerResult.Text = "Invalid input. Too many flowers";
            }
            else
            {
                int intervalFlwr = 0;
                int costFlwr = 0;
                //if the unit is a pre-Book III Infantry unit
                if (checkBox_infantry.Checked)
                {
                    for (int i = 1; i <= totalFlwr; i++)
                    {
                        if ((i == 11) || (i == 16)) intervalFlwr = 0;

                        if (i < 5)
                            intervalFlwr += 10;
                        if ((i >= 5) && (i < 7))
                            intervalFlwr += 20;
                        if ((i >= 7) && (i < 11))
                            intervalFlwr += 30;
                        if (i >= 11)
                            intervalFlwr += 40;
                        if (i > currentFlwr)
                            costFlwr += intervalFlwr;
                    }
                }
                //If unit is anything else
                else
                {
                   for (int i = 1; i <= totalFlwr; i++)
                   {
                        if ((i == 6) || (i == 11)) intervalFlwr = 0;
                            intervalFlwr += 40;
                        if (i > currentFlwr)
                            costFlwr += intervalFlwr;
                   }
                }
                label_flowerResult.Text = "That will cost " + costFlwr + " Flowers, and their flower level will be +" + totalFlwr;             
            }
        }

        private void comboBox_movement_SelectedIndexChanged(object sender, EventArgs e)
        {
            //Reveal "Pre-Book III Infantry" CheckBox and Label if Infantry is the selected movement type
            movement selectedMovement = (movement)Enum.Parse(typeof(movement), comboBox_movement.SelectedItem.ToString());
            if (selectedMovement == movement.Infantry)
            {
                label_infantry.Visible = true;
                checkBox_infantry.Visible = true;
                numericUpDown_currentFlower.Maximum = 19;
                numericUpDown_upgradeFlower.Maximum = 20;
            }else
            {
                label_infantry.Visible = false;
                checkBox_infantry.Visible = false;
                checkBox_infantry.Checked = false;
                numericUpDown_currentFlower.Maximum = 14;
                numericUpDown_upgradeFlower.Maximum = 15;
            }
        }
    }

    public enum movement { Infantry = 1, Armored = 2, Cavalry = 3, Flying = 4 }

}
