CREATE DATABASE [OnlineQuiz1]
GO
USE [OnlineQuiz1]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 4/21/2020 8:53:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NULL,
	[user_type] [bit] NULL,
	[email] [nvarchar](50) NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Question]    Script Date: 4/21/2020 8:53:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Question](
	[question_id] [int] IDENTITY(1,1) NOT NULL,
	[question] [nvarchar](max) NOT NULL,
	[option_1] [nvarchar](max) NULL,
	[option_2] [nvarchar](max) NULL,
	[option_3] [nvarchar](max) NULL,
	[option_4] [nvarchar](max) NULL,
	[answers] [nchar](10) NULL,
	[date_created] [datetime] NULL,
 CONSTRAINT [PK_Question] PRIMARY KEY CLUSTERED 
(
	[question_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[Account] ([username], [password], [user_type], [email]) VALUES (N'a', N'1', 0, N'dada@gmail.com')
INSERT [dbo].[Account] ([username], [password], [user_type], [email]) VALUES (N'abc', N'1', 0, N'dothanhdatfpt@gmail.com')
INSERT [dbo].[Account] ([username], [password], [user_type], [email]) VALUES (N'admin', N'admin', 1, N'admin@gmail.com')
INSERT [dbo].[Account] ([username], [password], [user_type], [email]) VALUES (N'admin0', N'admin', 0, N'dada@gmail.com')
INSERT [dbo].[Account] ([username], [password], [user_type], [email]) VALUES (N'admin10', N'admin', 0, N'jkhsd@gmail.com')
INSERT [dbo].[Account] ([username], [password], [user_type], [email]) VALUES (N'admin23', N'1', 0, N'kaitoukid09091999@gmail.com')
INSERT [dbo].[Account] ([username], [password], [user_type], [email]) VALUES (N'admin45', N'1', 1, N'dothanhdatfpt@gmail.com')
INSERT [dbo].[Account] ([username], [password], [user_type], [email]) VALUES (N'admin90', N'1A', 1, N'dothanhdatfpt@gmail.com')
INSERT [dbo].[Account] ([username], [password], [user_type], [email]) VALUES (N'b', N'1', 0, N'b@gmail.com')
INSERT [dbo].[Account] ([username], [password], [user_type], [email]) VALUES (N'c', N'1', 0, N'c@gmail.com')
INSERT [dbo].[Account] ([username], [password], [user_type], [email]) VALUES (N'dat', N'1', 0, N'dat@gmail.com')
INSERT [dbo].[Account] ([username], [password], [user_type], [email]) VALUES (N'dat1', N'1', 0, N'asd@gmail.com')
INSERT [dbo].[Account] ([username], [password], [user_type], [email]) VALUES (N'dat11_1999', N'1', 0, N'datdz@gmail.com')
INSERT [dbo].[Account] ([username], [password], [user_type], [email]) VALUES (N'dat1999', N'123456', 0, N'dat@gmail.com')
INSERT [dbo].[Account] ([username], [password], [user_type], [email]) VALUES (N'dat6', N'1', 1, N'dothanhdatfpt@gmail.com')
INSERT [dbo].[Account] ([username], [password], [user_type], [email]) VALUES (N'dothanhdat', N'1', 0, N'dat@gmail.com')
INSERT [dbo].[Account] ([username], [password], [user_type], [email]) VALUES (N'dothanhdat999', N'1', 1, N'dothanhdatfpt@gmail.com')
INSERT [dbo].[Account] ([username], [password], [user_type], [email]) VALUES (N'dothanhdat9992', N'1', 1, N'dothanhdatfpt@gmail.com')
INSERT [dbo].[Account] ([username], [password], [user_type], [email]) VALUES (N'dothanhdatfpt', N'1', 0, N'dothanhdatfpt@gmail.com')
INSERT [dbo].[Account] ([username], [password], [user_type], [email]) VALUES (N'k', N'1', 0, N'k@gmail.com')
INSERT [dbo].[Account] ([username], [password], [user_type], [email]) VALUES (N'm', N'1', 0, N'kaitoukid09091999@gmail.com')
INSERT [dbo].[Account] ([username], [password], [user_type], [email]) VALUES (N'mra', N'1', 0, N'dada@gmail.com')
SET IDENTITY_INSERT [dbo].[Question] ON 

INSERT [dbo].[Question] ([question_id], [question], [option_1], [option_2], [option_3], [option_4], [answers], [date_created]) VALUES (78, N'The name of capital of VietNam after year of 1975?', N'Sai Gon (it''s correct)', N'Ho Chi Minh', N'Ha Noi', N'Ha Tay', N'1         ', CAST(N'2020-03-10T20:49:47.120' AS DateTime))
INSERT [dbo].[Question] ([question_id], [question], [option_1], [option_2], [option_3], [option_4], [answers], [date_created]) VALUES (79, N'The name of capital of VietNam after year of 1975?', N'Sai Gon ', N'Ho Chi Minh (it''s correct)', N'Ha Noi', N'Ha Tay', N'2         ', CAST(N'2020-03-10T20:49:57.523' AS DateTime))
INSERT [dbo].[Question] ([question_id], [question], [option_1], [option_2], [option_3], [option_4], [answers], [date_created]) VALUES (80, N'The name of capital of VietNam after year of 1975?', N'Sai Gon ', N'Ho Chi Minh', N'Ha Noi (it''s correct)', N'Ha Tay', N'3         ', CAST(N'2020-03-10T20:50:06.613' AS DateTime))
INSERT [dbo].[Question] ([question_id], [question], [option_1], [option_2], [option_3], [option_4], [answers], [date_created]) VALUES (81, N'The name of capital of VietNam after year of 1975?', N'Sai Gon ', N'Ho Chi Minh', N'Ha Noi', N'Ha Tay (it''s correct)', N'4         ', CAST(N'2020-03-10T20:50:14.170' AS DateTime))
INSERT [dbo].[Question] ([question_id], [question], [option_1], [option_2], [option_3], [option_4], [answers], [date_created]) VALUES (82, N'Đây là câu hỏi test ?', N'Đây là đáp án đúng', N'Đây là đáp án đúng', N'Đây là đáp án sai', N'Đây là đáp án đúng', N'124       ', CAST(N'2020-03-10T20:51:52.363' AS DateTime))
INSERT [dbo].[Question] ([question_id], [question], [option_1], [option_2], [option_3], [option_4], [answers], [date_created]) VALUES (83, N'Đây là câu hỏi test ?', N'Đây là đáp án đúng', N'Đây là đáp án sai', N'Đây là đáp án sai', N'Đây là đáp án đúng', N'14        ', CAST(N'2020-03-10T20:52:01.143' AS DateTime))
INSERT [dbo].[Question] ([question_id], [question], [option_1], [option_2], [option_3], [option_4], [answers], [date_created]) VALUES (84, N'Đây là câu hỏi test ?', N'Đây là đáp án đúng', N'Đây là đáp án sai', N'Đây là đáp án sai', N'Đây là đáp án sai', N'1         ', CAST(N'2020-03-10T20:52:09.283' AS DateTime))
INSERT [dbo].[Question] ([question_id], [question], [option_1], [option_2], [option_3], [option_4], [answers], [date_created]) VALUES (85, N'Đây là câu hỏi test ?', N'Đây là đáp án sai', N'Đây là đáp án sai', N'Đây là đáp án sai', N'Đây là đáp án đúng', N'4         ', CAST(N'2020-03-10T20:52:33.610' AS DateTime))
INSERT [dbo].[Question] ([question_id], [question], [option_1], [option_2], [option_3], [option_4], [answers], [date_created]) VALUES (86, N'Ai là tác giả của Quốc Âm Thi Tập? ', N'Nguyễn Khuyến', N'Nguyễn Trãi (Đáp án đúng)', N'Quang Trung', N'Lê Thái Tổ', N'2         ', CAST(N'2020-03-10T20:54:41.193' AS DateTime))
INSERT [dbo].[Question] ([question_id], [question], [option_1], [option_2], [option_3], [option_4], [answers], [date_created]) VALUES (87, N'asdas', N'sadsa', N'sad', N'asdsa', N'das', N'24        ', CAST(N'2020-03-11T13:32:46.970' AS DateTime))
INSERT [dbo].[Question] ([question_id], [question], [option_1], [option_2], [option_3], [option_4], [answers], [date_created]) VALUES (88, N'qewjhwqkj', N'hkjh', N'kjh', N'kj', N'hjk', N'134       ', CAST(N'2020-03-22T21:18:23.837' AS DateTime))
INSERT [dbo].[Question] ([question_id], [question], [option_1], [option_2], [option_3], [option_4], [answers], [date_created]) VALUES (89, N'qewjhwqkj', N'hkjh', N'kjh', N'kj', N'hjk', N'134       ', CAST(N'2020-03-22T21:18:24.550' AS DateTime))
INSERT [dbo].[Question] ([question_id], [question], [option_1], [option_2], [option_3], [option_4], [answers], [date_created]) VALUES (90, N'qewjhwqkj', N'hkjh', N'kjh', N'kj', N'hjk', N'134       ', CAST(N'2020-03-22T21:18:24.710' AS DateTime))
INSERT [dbo].[Question] ([question_id], [question], [option_1], [option_2], [option_3], [option_4], [answers], [date_created]) VALUES (91, N'jahdskjh', N'khkjh', N'adsd', N'asdas', N'dsasd', N'2         ', CAST(N'2020-03-22T22:34:07.897' AS DateTime))
SET IDENTITY_INSERT [dbo].[Question] OFF
