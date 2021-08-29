USE [J6Store]
GO
/****** Object:  Table [dbo].[accounts]    Script Date: 27/08/2021 15:43:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[accounts](
	[username] [nvarchar](50) NOT NULL,
	[email] [varchar](50) NULL,
	[fullname] [nvarchar](50) NULL,
	[password] [varchar](50) NULL,
	[photo] [nvarchar](255) NULL,
	[Reset_Token] [nvarchar](50) NULL,
	[verification_code] [nvarchar](64) NULL,
	[enabled] [bit] NULL,
	[password_changed_time] [datetime] NULL,
 CONSTRAINT [PK__accounts__F3DBC573B3E3E89E] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[authorities]    Script Date: 27/08/2021 15:43:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[authorities](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NULL,
	[roleid] [nvarchar](50) NULL,
 CONSTRAINT [PK__authorit__3213E83F5D43ECC6] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[categories]    Script Date: 27/08/2021 15:43:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[categories](
	[id] [varchar](255) NOT NULL,
	[name] [nvarchar](255) NULL,
 CONSTRAINT [PK__categori__3213E83F7AD44528] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[orderdetails]    Script Date: 27/08/2021 15:43:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[orderdetails](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[price] [float] NULL,
	[quantity] [int] NULL,
	[orderid] [bigint] NULL,
	[productid] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[orders]    Script Date: 27/08/2021 15:43:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[orders](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[address] [varchar](255) NULL,
	[createdate] [date] NULL,
	[username] [nvarchar](50) NULL,
 CONSTRAINT [PK__orders__3213E83FE995AA91] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[products]    Script Date: 27/08/2021 15:43:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[products](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[available] [bit] NULL,
	[createdate] [date] NULL,
	[image] [varchar](255) NULL,
	[name] [nvarchar](255) NULL,
	[price] [float] NULL,
	[categoryid] [varchar](255) NULL,
	[description] [nvarchar](255) NULL,
	[discount] [float] NULL,
	[quantity] [int] NULL,
 CONSTRAINT [PK__products__3213E83F6B1E1DE6] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[roles]    Script Date: 27/08/2021 15:43:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[roles](
	[id] [nvarchar](50) NOT NULL,
	[name] [nvarchar](50) NULL,
 CONSTRAINT [PK__roles__3213E83F6D0CAD32] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[authorities]  WITH CHECK ADD  CONSTRAINT [FKevi9708lm1k06pa4dugc91k7v] FOREIGN KEY([roleid])
REFERENCES [dbo].[roles] ([id])
GO
ALTER TABLE [dbo].[authorities] CHECK CONSTRAINT [FKevi9708lm1k06pa4dugc91k7v]
GO
ALTER TABLE [dbo].[authorities]  WITH CHECK ADD  CONSTRAINT [FKlw0sapcjvuxfa1kvyjw7jml88] FOREIGN KEY([username])
REFERENCES [dbo].[accounts] ([username])
GO
ALTER TABLE [dbo].[authorities] CHECK CONSTRAINT [FKlw0sapcjvuxfa1kvyjw7jml88]
GO
ALTER TABLE [dbo].[orderdetails]  WITH CHECK ADD  CONSTRAINT [FKaltatpxipsjtcih4d1h6bn0xr] FOREIGN KEY([productid])
REFERENCES [dbo].[products] ([id])
GO
ALTER TABLE [dbo].[orderdetails] CHECK CONSTRAINT [FKaltatpxipsjtcih4d1h6bn0xr]
GO
ALTER TABLE [dbo].[orderdetails]  WITH CHECK ADD  CONSTRAINT [FKj4gc2ja2otvwemf4rho2lp3s8] FOREIGN KEY([orderid])
REFERENCES [dbo].[orders] ([id])
GO
ALTER TABLE [dbo].[orderdetails] CHECK CONSTRAINT [FKj4gc2ja2otvwemf4rho2lp3s8]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FKk3cjfcgb621qhahps1tre43e4] FOREIGN KEY([username])
REFERENCES [dbo].[accounts] ([username])
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FKk3cjfcgb621qhahps1tre43e4]
GO
ALTER TABLE [dbo].[products]  WITH CHECK ADD  CONSTRAINT [FK1krrsjgcawsfg8k8u4hm5gi8q] FOREIGN KEY([categoryid])
REFERENCES [dbo].[categories] ([id])
GO
ALTER TABLE [dbo].[products] CHECK CONSTRAINT [FK1krrsjgcawsfg8k8u4hm5gi8q]
GO
