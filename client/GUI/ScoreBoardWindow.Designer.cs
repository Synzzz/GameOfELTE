namespace GameOfELTE.GUI
{
    partial class ScoreBoardWindow
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
            this.scoreboard = new System.Windows.Forms.SplitContainer();
            this.btn_ok = new System.Windows.Forms.Button();
            this.lstBox_players = new System.Windows.Forms.ListBox();
            this.lstBox_scores = new System.Windows.Forms.ListBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.scoreboard)).BeginInit();
            this.scoreboard.Panel1.SuspendLayout();
            this.scoreboard.Panel2.SuspendLayout();
            this.scoreboard.SuspendLayout();
            this.SuspendLayout();
            // 
            // scoreboard
            // 
            this.scoreboard.Location = new System.Drawing.Point(12, 33);
            this.scoreboard.Name = "scoreboard";
            // 
            // scoreboard.Panel1
            // 
            this.scoreboard.Panel1.Controls.Add(this.lstBox_players);
            // 
            // scoreboard.Panel2
            // 
            this.scoreboard.Panel2.Controls.Add(this.lstBox_scores);
            this.scoreboard.Size = new System.Drawing.Size(410, 167);
            this.scoreboard.SplitterDistance = 331;
            this.scoreboard.TabIndex = 0;
            // 
            // btn_ok
            // 
            this.btn_ok.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.btn_ok.Location = new System.Drawing.Point(185, 206);
            this.btn_ok.Name = "btn_ok";
            this.btn_ok.Size = new System.Drawing.Size(75, 23);
            this.btn_ok.TabIndex = 1;
            this.btn_ok.Text = "Ok";
            this.btn_ok.UseVisualStyleBackColor = true;
            // 
            // lstBox_players
            // 
            this.lstBox_players.Dock = System.Windows.Forms.DockStyle.Fill;
            this.lstBox_players.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lstBox_players.FormattingEnabled = true;
            this.lstBox_players.ItemHeight = 16;
            this.lstBox_players.Location = new System.Drawing.Point(0, 0);
            this.lstBox_players.Name = "lstBox_players";
            this.lstBox_players.Size = new System.Drawing.Size(331, 167);
            this.lstBox_players.TabIndex = 0;
            // 
            // lstBox_scores
            // 
            this.lstBox_scores.Dock = System.Windows.Forms.DockStyle.Fill;
            this.lstBox_scores.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lstBox_scores.FormattingEnabled = true;
            this.lstBox_scores.ItemHeight = 16;
            this.lstBox_scores.Location = new System.Drawing.Point(0, 0);
            this.lstBox_scores.Name = "lstBox_scores";
            this.lstBox_scores.Size = new System.Drawing.Size(75, 167);
            this.lstBox_scores.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(13, 14);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(80, 16);
            this.label1.TabIndex = 2;
            this.label1.Text = "Játékosok";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(344, 14);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(56, 16);
            this.label2.TabIndex = 2;
            this.label2.Text = "Pontok";
            // 
            // ScoreBoardWindow
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(434, 241);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btn_ok);
            this.Controls.Add(this.scoreboard);
            this.Name = "ScoreBoardWindow";
            this.Text = "Eredménytábla";
            this.scoreboard.Panel1.ResumeLayout(false);
            this.scoreboard.Panel2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.scoreboard)).EndInit();
            this.scoreboard.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.SplitContainer scoreboard;
        private System.Windows.Forms.ListBox lstBox_players;
        private System.Windows.Forms.ListBox lstBox_scores;
        private System.Windows.Forms.Button btn_ok;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
    }
}