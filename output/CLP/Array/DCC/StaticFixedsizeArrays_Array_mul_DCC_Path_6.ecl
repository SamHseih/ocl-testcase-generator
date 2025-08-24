:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

staticFixedsizeArrays_Array_mul_DCC_Path_6(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_datas,Self_dimensionSizes],Self_dimensionSizes = [5],
Arg=[Arg_datas,Arg_dimensionSizes],Arg_dimensionSizes = [5],
Result = [Result_datas,Result_dimensionSizes],Result_dimensionSizes = [5],

decl_Array(Self_datas,Self_dimensionSizes),
decl_Array(Arg_datas,Arg_dimensionSizes),
decl_Array(Result_datas,Result_dimensionSizes),

%CLG Path Constrints,
nth1(1,Arg_dimensionSizes,Var_1932831450),
(Dim1 = Var_1932831450),
(Acc = true),
(Index0 #= 1),
(Index0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_496729294),nth1(Index0,List_496729294,Var_496729294),(It = Var_496729294),
getArrayElement(Arg_datas,[It],Var_1302227152_1),getArrayElement(Self_datas,[It],Var_1122606666_1),getArrayElement(Result_datas,[It],Var_350068407_1),(Var_350068407_1 #= (Var_1122606666_1*Var_1302227152_1)),
(Index0_1 #= (Index0+1)),
(Index0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_496729294),nth1(Index0_1,List_496729294,Var_496729294_1),(It_1 = Var_496729294_1),
getArrayElement(Arg_datas,[It_1],Var_1302227152_2),getArrayElement(Self_datas,[It_1],Var_1122606666_2),getArrayElement(Result_datas,[It_1],Var_350068407_2),(Var_350068407_2 #= (Var_1122606666_2*Var_1302227152_2)),
(Index0_2 #= (Index0_1+1)),
(Index0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_496729294),nth1(Index0_2,List_496729294,Var_496729294_2),(It_2 = Var_496729294_2),
getArrayElement(Arg_datas,[It_2],Var_1302227152_3),getArrayElement(Self_datas,[It_2],Var_1122606666_3),getArrayElement(Result_datas,[It_2],Var_350068407_3),(Var_350068407_3 #= (Var_1122606666_3*Var_1302227152_3)),
(Index0_3 #= (Index0_2+1)),
(Index0_3 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_496729294),nth1(Index0_3,List_496729294,Var_496729294_3),(It_3 = Var_496729294_3),
getArrayElement(Arg_datas,[It_3],Var_1302227152_4),getArrayElement(Self_datas,[It_3],Var_1122606666_4),getArrayElement(Result_datas,[It_3],Var_350068407_4),(Var_350068407_4 #= (Var_1122606666_4*Var_1302227152_4)),
(Index0_4 #= (Index0_3+1)),
(Index0_4 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_496729294),nth1(Index0_4,List_496729294,Var_496729294_4),(It_4 = Var_496729294_4),
getArrayElement(Arg_datas,[It_4],Var_1302227152_5),getArrayElement(Self_datas,[It_4],Var_1122606666_5),getArrayElement(Result_datas,[It_4],Var_350068407_5),(Var_350068407_5 #= (Var_1122606666_5*Var_1302227152_5)),
(Index0_5 #= (Index0_4+1)),
(Index0_5 #> Dim1 - 1+ 1),

%TypeVar Labeling Parts
labeling_Arrays([Self_datas, Arg_datas]).
