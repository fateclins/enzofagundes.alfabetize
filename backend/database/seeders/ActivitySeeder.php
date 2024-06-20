<?php

namespace Database\Seeders;

use App\Models\Module;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class ActivitySeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        // Create activities for the first module
        $module1 = Module::find(1);
        $module1->activities()->createMany([
            [
                'title' => 'Aprenda o alfabeto',
                'content' => 'O que é o alfabeto?',
                'type' => 'writing',
                'correct_answer' => 'O alfabeto é a sequência de letras que compõem as palavras.',
                'points' => 10,
            ],
            [
                'title' => 'Aprenda as vogais',
                'content' => 'Quais são as vogais?',
                'type' => 'writing',
                'correct_answer' => 'As vogais são as letras A, E, I, O e U.',
                'points' => 10,
            ],
        ]);

        // Create activities for the second module
        $module2 = Module::find(2);
        $module2->activities()->createMany([
            [
                'title' => 'Aprenda a somar',
                'content' => 'O que é a soma?',
                'type' => 'writing',
                'correct_answer' => 'A soma é a operação matemática que consiste em adicionar dois ou mais números.',
                'points' => 10,
            ],
            [
                'title' => 'Aprenda a subtrair',
                'content' => 'O que é a subtração?',
                'type' => 'writing',
                'correct_answer' => 'A subtração é a operação matemática que consiste em retirar um número de outro.',
                'points' => 10,
            ],
        ]);
    }
}
