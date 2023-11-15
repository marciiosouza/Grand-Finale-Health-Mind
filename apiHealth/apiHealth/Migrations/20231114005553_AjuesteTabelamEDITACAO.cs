using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace apiHealth.Migrations
{
    /// <inheritdoc />
    public partial class AjuesteTabelamEDITACAO : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.RenameColumn(
                name: "CaminhoVideo",
                table: "tb_Meditacoes",
                newName: "CaminhoArquivo");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.RenameColumn(
                name: "CaminhoArquivo",
                table: "tb_Meditacoes",
                newName: "CaminhoVideo");
        }
    }
}
