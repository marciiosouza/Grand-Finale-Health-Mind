using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace apiHealth.Migrations
{
    /// <inheritdoc />
    public partial class TabelaMeditacao : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "tb_Meditacoes",
                columns: table => new
                {
                    MeditacaoId = table.Column<int>(type: "NUMBER(10)", nullable: false)
                        .Annotation("Oracle:Identity", "START WITH 1 INCREMENT BY 1"),
                    Titulo = table.Column<string>(type: "NVARCHAR2(2000)", nullable: false),
                    CaminhoVideo = table.Column<string>(type: "NVARCHAR2(2000)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_tb_Meditacoes", x => x.MeditacaoId);
                });
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "tb_Meditacoes");
        }
    }
}
