namespace GameOfELTE.GUI
{
    partial class UnregisterSubjectWindow
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
            this.lstBox_subjects = new System.Windows.Forms.ListBox();
            this.btn_abandon = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // lstBox_subjects
            // 
            this.lstBox_subjects.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lstBox_subjects.FormattingEnabled = true;
            this.lstBox_subjects.ItemHeight = 15;
            this.lstBox_subjects.Location = new System.Drawing.Point(12, 76);
            this.lstBox_subjects.Name = "lstBox_subjects";
            this.lstBox_subjects.Size = new System.Drawing.Size(288, 319);
            this.lstBox_subjects.TabIndex = 11;
            // 
            // btn_abandon
            // 
            this.btn_abandon.Location = new System.Drawing.Point(114, 408);
            this.btn_abandon.Name = "btn_abandon";
            this.btn_abandon.Size = new System.Drawing.Size(90, 25);
            this.btn_abandon.TabIndex = 10;
            this.btn_abandon.Text = "Tárgy leadása";
            this.btn_abandon.UseVisualStyleBackColor = true;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(35, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(241, 64);
            this.label1.TabIndex = 9;
            this.label1.Text = "Ezt majd át kell írni annak megfelelően, \r\nhogy mi miatt kell leadnia, 4. hiányzá" +
    "s,\r\nelengedés, rossz időpont stb. \r\nvagy ki lehet törölni egy az egybe";
            this.label1.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // UnregisterSubjectWindow
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(316, 445);
            this.Controls.Add(this.lstBox_subjects);
            this.Controls.Add(this.btn_abandon);
            this.Controls.Add(this.label1);
            this.Name = "UnregisterSubjectWindow";
            this.Text = "UnregisterSubjectWindow";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListBox lstBox_subjects;
        private System.Windows.Forms.Button btn_abandon;
        private System.Windows.Forms.Label label1;
    }
}