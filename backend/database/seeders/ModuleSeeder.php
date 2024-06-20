<?php

namespace Database\Seeders;

use App\Models\Module;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class ModuleSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        Module::create([
            'title' => 'Alfabetização Básica',
            'description' => 'Aprenda o alfabeto e as vogais',
        ]);

        Module::create([
            'title' => 'Matemática Básica',
            'description' => 'Aprenda a somar e subtrair',
        ]);
    }
}
