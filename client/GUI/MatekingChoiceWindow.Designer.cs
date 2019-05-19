namespace GameOfELTE.GUI
{
    partial class MatekingChoiceWindow
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
            this.btn_pay = new System.Windows.Forms.Button();
            this.btn_later = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(12, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(434, 32);
            this.label1.TabIndex = 7;
            this.label1.Text = "Választhatsz hogy fizetsz 50 000 Ft-ot így szerezve tudást Mateking által, \r\nvagy" +
    " később használod fel.";
            this.label1.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // btn_pay
            // 
            this.btn_pay.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_pay.Location = new System.Drawing.Point(15, 54);
            this.btn_pay.Name = "btn_pay";
            this.btn_pay.Size = new System.Drawing.Size(158, 47);
            this.btn_pay.TabIndex = 8;
            this.btn_pay.Text = "Fizetek (+1 Tudás)";
            this.btn_pay.UseVisualStyleBackColor = true;
            // 
            // btn_later
            // 
            this.btn_later.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_later.Location = new System.Drawing.Point(280, 54);
            this.btn_later.Name = "btn_later";
            this.btn_later.Size = new System.Drawing.Size(158, 47);
            this.btn_later.TabIndex = 8;
            this.btn_later.Text = "Később";
            this.btn_later.UseVisualStyleBackColor = true;
            // 
            // MatekingChoiceWindow
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(450, 113);
            this.Controls.Add(this.btn_later);
            this.Controls.Add(this.btn_pay);
            this.Controls.Add(this.label1);
            this.Name = "MatekingChoiceWindow";
            this.Text = "50% Mateking leárazás";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btn_pay;
        private System.Windows.Forms.Button btn_later;
    }
}