﻿namespace GameOfELTE.GUI
{
    partial class LosingKnowledgeWindow
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.lstBox_subjects = new System.Windows.Forms.ListBox();
            this.btn_ok = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(12, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(330, 32);
            this.label1.TabIndex = 1;
            this.label1.Text = "Rákockultál egy új játékra ami miatt kihagytál pár órát, \r\nveszítesz egy tudást a" +
    "z általad választott tárgyból.";
            this.label1.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // lstBox_subjects
            // 
            this.lstBox_subjects.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lstBox_subjects.FormattingEnabled = true;
            this.lstBox_subjects.ItemHeight = 15;
            this.lstBox_subjects.Location = new System.Drawing.Point(15, 44);
            this.lstBox_subjects.Name = "lstBox_subjects";
            this.lstBox_subjects.Size = new System.Drawing.Size(324, 334);
            this.lstBox_subjects.TabIndex = 5;
            // 
            // btn_ok
            // 
            this.btn_ok.Location = new System.Drawing.Point(103, 384);
            this.btn_ok.Name = "btn_ok";
            this.btn_ok.Size = new System.Drawing.Size(144, 23);
            this.btn_ok.TabIndex = 4;
            this.btn_ok.Text = "Ok";
            this.btn_ok.UseVisualStyleBackColor = true;
            // 
            // LosingKnowledgeWindow
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(351, 416);
            this.Controls.Add(this.lstBox_subjects);
            this.Controls.Add(this.btn_ok);
            this.Controls.Add(this.label1);
            this.Name = "LosingKnowledgeWindow";
            this.Text = "Elveszett tudás";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ListBox lstBox_subjects;
        private System.Windows.Forms.Button btn_ok;
    }
}